/**
 * Recursion version
 * Time complexity: O(N)
 * Space complexity: O(height(N))
 *
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return root;
            
        if (root.left != null) 
            invertTree(root.left);
        if (root.right != null) 
            invertTree(root.right);
        
        // invert children node
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }
}