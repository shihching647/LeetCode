/**
 * Recursion:
 * preorder - {root, left, right}
 * 故從left開始建立root, 並使用preorderIndex紀錄目前建立的root位置
 * 使用left, right來決定subTree的範圍, 當left > right代表無subtree
 *
 * Time complexity: O(N)
 * Space complexity: O(N)
 *
 */
class Solution {
    private int preorderIndex;
    private Map<Integer, Integer> inorderIndexMap;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        preorderIndex = 0;
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < n; i++)
            inorderIndexMap.put(inorder[i], i);
        return buildTree(preorder, 0, n - 1);
    }
    
    private TreeNode buildTree(int[] preorder, int left, int right) {
        if (left > right) 
            return null;
        TreeNode x = new TreeNode(preorder[preorderIndex++]);
        int inorderIndex = inorderIndexMap.get(x.val);
        // excluding inorderIndexMap[x.val] element because it's the root
        x.left = buildTree(preorder, left, inorderIndex - 1);
        x.right = buildTree(preorder, inorderIndex + 1, right);
        return x;
    }
}