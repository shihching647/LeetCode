/**
 * Recursion:
 * postorder - {left, right, root}
 * 故從right開始建立root, 並使用postorderIndex紀錄目前建立的root位置
 * 使用left, right來決定subTree的範圍, 當left > right代表無subtree
 *
 * Time complexity: O(N)
 * Space complexity: O(N)
 *
 */
class Solution {
    private int postorderIndex;
    private Map<Integer, Integer> inorderIndexMap;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        postorderIndex = n - 1;
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < n; i++)
            inorderIndexMap.put(inorder[i], i);
        return buildTree(postorder, 0, n - 1);
    }
    
    private TreeNode buildTree(int[] postorder, int left, int right) {
        if (left > right)
            return null;
        TreeNode x = new TreeNode(postorder[postorderIndex--]);
        int inorderIndex = inorderIndexMap.get(x.val);
        x.right = buildTree(postorder, inorderIndex + 1, right);
        x.left = buildTree(postorder, left, inorderIndex - 1);
        return x;
    }
    
}