/**
 * Recursion:
 * inorder = {left, root, right}
 * postorder = {left, right, root}
 *
 * 先用一個map紀錄inorder[i] -> i (因為inorder位置左邊是left tree,右邊是right tree)
 * postorder最右邊的位置是root所在, 由後往前resursive建立整個tree
 *
 * Time complexity: O(N)
 * Space complexity: O(N)
 *
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++)
            map.put(inorder[i], i);
        TreeNode root = build(inorder, 0, n - 1, postorder, 0, n - 1, map);
        return root;
    }
    
    private TreeNode build(int[] inorder, int is, int ie, int[] postorder, int ps, int pe, HashMap<Integer, Integer> map) {
        if (is > ie || ps > pe) // is == ie, ps == pe代表還有一個root須建立, 故使用>, 而非>=
            return null;
        
        TreeNode root = new TreeNode(postorder[pe]);
        int ri = map.get(postorder[pe]); // root index
        // inorder = {left, root, right}
        // postorder = {left, right, root}
        // 不管用哪一種方式, lenLeft 與 lenRight都會一樣
        int lenLeft = ri - 1 - is;
        int lenRight = ie - (ri + 1);
        
        // inorder的index從 is ~ ri - 1, postorder的index從 ps ~ ps + lenLeft
        root.left = build(inorder, is, ri - 1, postorder, ps, ps + lenLeft, map); 
        // inorder的index從 ri + 1 ~ ie, postorder的index從 ps ~ ps + lenLeft = pe - 1 - lenRight ~ pe - 1
        root.right = build(inorder, ri + 1, ie, postorder, pe - 1 - lenRight, pe - 1, map); 
        return root;
    }
    
}