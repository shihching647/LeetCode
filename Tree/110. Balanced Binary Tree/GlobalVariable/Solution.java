/**
 * Recursion:
 * 使用global variable isBalanced 當作flag
 * 當isBalanced為true的時候才需要繼續遞迴下去
 * (需要使用flag原因是因為需要傳遞兩個資訊, 一個是高度,一個是是否為balane tree)
 * 
 * Time complexity: O(N)
 * Space complexity: O(N)
 *
 */
class Solution {
    
    private boolean isBalanced = true;
    
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return isBalanced;
    }
    
    private int dfs(TreeNode x) {
        if (!isBalanced || x == null) {
            return 0;
        }
        int lh = 0, rh = 0;
        lh = dfs(x.left);
        if (isBalanced)
            rh = dfs(x.right);
        if (Math.abs(lh - rh) > 1) 
            isBalanced = false;
        return Math.max(lh, rh) + 1;
    }
}