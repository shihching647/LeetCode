/**
 * DFS
 * 
 * Time complexity: O(N)
 * Space complexity: O(h)
 *
 */
// 
class Solution {
    
    private int ans = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }
    
    private int dfs(TreeNode x) {
        if (x == null)
            return 0;
        // find the heights of left and right subTrees (與height相比其實會多1)
        int left = dfs(x.left);
        int right = dfs(x.right);
        ans = Math.max(ans, left + right);
        return Math.max(left, right) + 1;
    }
}