/**
 * Recursion:
 *
 * Time complexity: O(N)
 * Space complexity: O(logN)
 *
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }
    
    private TreeNode buildTree(int[] nums, int left, int right) {
        if (left > right)
            return null;
        int root = (left + right) / 2;
        TreeNode x = new TreeNode(nums[root]);
        x.left = buildTree(nums, left, root - 1);
        x.right = buildTree(nums, root + 1, right);
        return x;
    }
}