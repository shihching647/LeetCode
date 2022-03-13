/**
 * DP(Bottom Up)
 * DP(i, j)定義為 : 從(0, 0)出發到達(i, j)共有幾種走法
 * 
 * Time complexity: O(m * n)
 * Space complexity: O(m *　ｎ)
 */

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}