/**
 * Recursive preorder traversal
 *
 * Time complexity: O(N)
 * Space complexity: O(h)
 *
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // recursion method
        if (root == null) 
            return false;
        if (root.left == null && root.right == null && root.val == targetSum) 
            return true;
        
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}