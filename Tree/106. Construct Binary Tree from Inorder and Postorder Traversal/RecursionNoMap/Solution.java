/**
 * Recursion: 
 *
 * Reference: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/discuss/34543/Simple-O(n)-without-map
 *
 * Time complexity: O(N)
 * Space complexity: O(N)
 *
 */
class Solution {
    
    private int post, in; 
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        post = postorder.length - 1;
        in = postorder.length - 1;
        return buildTree(inorder, postorder, null);
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, Integer stop) {
        if (post < 0)
            return null;
        if (stop != null && inorder[in] == stop) {
            in--;
            return null;
        }
        
        TreeNode x = new TreeNode(postorder[post--]);
        x.right = buildTree(inorder, postorder, x.val);
        x.left = buildTree(inorder, postorder, stop);
        return x;
    }
    
}