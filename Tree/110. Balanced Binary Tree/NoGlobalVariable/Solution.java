/**
 * Recursion:
 * 使用-1來當作發現不是balanced tree
 * 
 * Time complexity: O(N)
 * Space complexity: O(N)
 *
 */
class Solution {
        
    public boolean isBalanced(TreeNode root) {
        return dfs(root) != -1;
    }
    
    private int dfs(TreeNode x) {
        if (x == null) {
            return 0;
        }
        int lh = 0, rh = 0;
        
        lh = dfs(x.left);
        if (lh < 0)
            return -1;
        
        rh = dfs(x.right);
        if (rh < 0)
            return -1;
        
        if (Math.abs(lh - rh) > 1)
            return -1;
        
        return Math.max(lh, rh) + 1;
    }
}