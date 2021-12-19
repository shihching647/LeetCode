/**
 * DP (Top Down): 
 * dp[i][j] = 從位置i, j會到達最右下角所需的最小血量
 * (一開始定義dp[i][j]為到達i, j會扣的最小血量, 但無法解出)
 * 
 * 參考: https://www.youtube.com/watch?v=pt-xIS6huIg&ab_channel=HuaHua
 * Time Complexity: O(n^2)
 * Space Complexity: O(n^2)
 */

class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n]; // 從位置i, j會到達最右下角所需的最小血量       
        return calculateMinHP(dungeon, 0, 0, dp);
    }
    
    private int calculateMinHP(int[][] dungeon, int i, int j, int[][] dp) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        // out of bound return MAX
        if (i >= m || j >= n) {
            return Integer.MAX_VALUE;
        }
        
        // memoization
        if (dp[i][j] > 0)
            return dp[i][j];
        
        // base case
        if (j == n - 1 && i == m - 1) {
            if (dungeon[i][j] > 0) {
                dp[i][j] = 1;
            } else {
                dp[i][j] = -dungeon[i][j] + 1;
            }
            return dp[i][j];
        }
        
        dp[i][j] = Math.max(1, Math.min(calculateMinHP(dungeon, i + 1, j, dp), calculateMinHP(dungeon, i, j + 1, dp)) - dungeon[i][j]);
        return dp[i][j];
    }
    
}