/**
 * Recursive preorder traversal
 *
 * Time complexity: O(N)
 * Space complexity: O(h)
 *
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return preorder(root, targetSum, false);
    }
    
    private boolean preorder(TreeNode x, int target, boolean findAns) {
        if (x == null || findAns)
            return findAns;
        target -= x.val;
        if (x.left == null && x.right == null) 
            return target == 0;
        findAns = preorder(x.left, target, findAns);
        findAns = preorder(x.right, target, findAns);
        return findAns;
    }
}