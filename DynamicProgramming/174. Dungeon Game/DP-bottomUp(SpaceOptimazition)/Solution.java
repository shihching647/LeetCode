/**
 * DP (Bottom up): 空間優化
 * dp[i][j] = 從位置i, j會到達最右下角所需的最小血量
 * (一開始定義dp[i][j]為到達i, j會扣的最小血量, 但無法解出)
 * 
 * 參考: https://www.youtube.com/watch?v=pt-xIS6huIg&ab_channel=HuaHua
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 */

class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[] dp = new int[n + 1]; // 從位置m, n會到達最右下角所需的最小血量
        
        // init
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        // dp[n - 1][m - 1]的右邊和下邊設為1, 代表到該格至少要剩下1滴血.
        dp[n] = dp[n - 1] = 1;
        
        // 填dp table
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                dp[j] = Math.max(1, Math.min(dp[j + 1], dp[j]) - dungeon[i][j]);
            }
            dp[n] = Integer.MAX_VALUE;
        }
        return dp[0];
    }
}