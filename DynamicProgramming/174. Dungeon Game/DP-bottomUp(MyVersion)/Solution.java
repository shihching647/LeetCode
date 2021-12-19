/**
 * DP (Bottom Up): 
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
        int[][] dp = new int[m][n]; // 從位置m, n會到達最右下角所需的最小血量
        
        // 如果該格是補血, 則最小需要1滴血, 故需要取與1的max
        
        // 最後一格
        dp[m - 1][n - 1] = Math.max(1, 1 - dungeon[m - 1][n - 1]);
        
        // 最下面那一列
        for (int j = n - 2; j >= 0; j--) {
            dp[m - 1][j] = Math.max(1, dp[m - 1][j + 1] - dungeon[m - 1][j]);
        }
        
        // 最右邊那一列
        for (int i = m - 2; i >= 0; i--) {
            dp[i][n - 1] = Math.max(1, dp[i + 1][n - 1] - dungeon[i][n - 1]);
        }
        
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = Math.max(1, Math.min(dp[i][j + 1], dp[i + 1][j]) - dungeon[i][j]);
            }
        }
        return dp[0][0];
    }
}