/**
 * DP(Bottom Up)
 * DP(i, j)定義為 : 從(0, 0)出發到達(i, j)共有幾種走法
 * 
 * Time complexity: O(m * n)
 * Space complexity: O(m)
 */

class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            dp[0] = 1;
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[n - 1];
    }
}