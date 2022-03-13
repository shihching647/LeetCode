/**
 * Recursion:
 *
 * Time complexity: O(N)
 * Space complexity: O(h)
 *
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }
    
    private boolean isSymmetric(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) 
            return true;
        if (leftNode == null || rightNode == null)
            return false;
        if (leftNode.val != rightNode.val)
            return false;
        return isSymmetric(leftNode.right, rightNode.left) && isSymmetric(leftNode.left, rightNode.right);
    }
}