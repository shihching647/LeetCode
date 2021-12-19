/**
 * DP (Bottom up): 
 * dp[i][j] = 從位置i, j會到達最右下角所需的最小血量
 * (一開始定義dp[i][j]為到達i, j會扣的最小血量, 但無法解出)
 * 
 * dp開成m + 1, n + 1會比較好做
 * 
 * 參考: https://www.youtube.com/watch?v=pt-xIS6huIg&ab_channel=HuaHua
 * Time Complexity: O(n^2)
 * Space Complexity: O(n^2)
 */

class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m + 1][n + 1]; // 從位置m, n會到達最右下角所需的最小血量
        
        // init
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[m][n - 1] = dp[m - 1][n] = 1;
        
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                dp[i][j] = Math.max(1, Math.min(dp[i][j + 1], dp[i + 1][j]) - dungeon[i][j]);
            }
        }
        return dp[0][0];
    }
}