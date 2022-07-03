/**
 * DFS
 * 
 * Time complexity: O(N)
 * Space complexity: O(h)
 *
 */
// 
class Solution {
    
    public int diameterOfBinaryTree(TreeNode root) {
        return dfs(root)[1];
    }
    
    private int[] dfs(TreeNode x) {
        if (x == null)
            return new int[]{0, 0};
        // find the heights of left and right subTrees (與height相比其實會多1)
        int[] left = dfs(x.left);
        int[] right = dfs(x.right);
        int height = Math.max(left[0], right[0]) + 1;
        int diameter = Math.max(left[0] + right[0], Math.max(left[1], right[1]));
        return new int[]{height, diameter};
    }
}