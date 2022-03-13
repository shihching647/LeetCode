/**
 * DP(Bottom up)
 * DP(i, j)定義為 : 從(0, 0)到(i, j)可組成的元素都為1的最大正方形的邊長
 * 
 * 
 * Time complexity: O(m * n)
 * Space complexity: O(m * n)
 */
class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        int maxLen = 0;
        for (int y = 1; y <= m; y++) {
            for (int x = 1; x <= n; x++) {
                if (matrix[y - 1][x - 1] - '0' == 1) { // 只有當該元素為1時才需考慮. 若該元素為0, dp[y][x] = 0.
                    // 以最小的那個為主導(可參考圖)
                    dp[y][x] = Math.min(dp[y - 1][x], Math.min(dp[y][x - 1], dp[y - 1][x - 1])) + 1;
                    maxLen = Math.max(maxLen, dp[y][x]);
                }
            }
        }
        return maxLen * maxLen;
    }
}