/**
 * Recursion version
 *
 * Time complexity: O(N)
 * Space complexity: O(N)
 *
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}