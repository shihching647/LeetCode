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
        int[] dp = new int[n + 1];
        int maxLen = 0;
        int pre = dp[0];
        for (int y = 1; y <= m; y++) {
            for (int x = 1; x <= n; x++) {
                int temp = dp[x];
                if (matrix[y - 1][x - 1] - '0' == 1) {
                    dp[x] = Math.min(dp[x], Math.min(pre, dp[x - 1])) + 1;
                    maxLen = Math.max(maxLen, dp[x]);
                } else { // 若該位置為0, dp[x]為0
                    dp[x] = 0;
                }
                pre = temp;
            }
        }
        return maxLen * maxLen;
    }
}