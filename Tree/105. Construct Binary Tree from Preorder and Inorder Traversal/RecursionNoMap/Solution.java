/**
 * Recursion: 
 * 使用stop紀錄root的值, 當inorder[in]遇到root的值時, 此時就知道left subTree已經結束
 *
 * Reference: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/discuss/34543/Simple-O(n)-without-map
 *
 * Time complexity: O(N)
 * Space complexity: O(N)
 *
 */
class Solution {
    
    private int pre, in;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, null);
    }
    
    private TreeNode buildTree(int[] preorder, int[] inorder, Integer stop) {
        if (pre >= preorder.length) 
            return null;
        // inorder[in]遇到root的值代表已結束, return null
        if (stop != null && inorder[in] == stop) {
            in++; // 此時in要往前移一格
            return null;
        }
        TreeNode x = new TreeNode(preorder[pre++]);
        x.left = buildTree(preorder, inorder, x.val);
        x.right = buildTree(preorder, inorder, stop);
        return x;
    }
}