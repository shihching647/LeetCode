/**
 * Recursive check
 * 每一個node都會有max, min只要不介於此範圍間就不適BST(max, min只要是null就當作沒有範圍)
 *
 * Time complexity: O(N)
 * Space complexity: O(h)
 *
 */
class Solution {
    
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }
    
    private boolean isValidBST(TreeNode x, Integer min, Integer max) {
        if (x == null) return true;
        if (min != null && x.val <= min) return false;
        if (max != null && x.val >= max) return false;
        return isValidBST(x.left, min, x.val) && isValidBST(x.right, x.val, max);
    }
}