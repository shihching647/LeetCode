/**
 * DP (Bottom Up): 
 * dp[i] = 組成數字i需用到的最小平方數的個數
 * 
 * 參考: https://www.youtube.com/watch?v=1xfx6M_GqFk&ab_channel=TECHDOSE
 * Time Complexity: O(n√n)
 * Space Complexity: O(n)
 */

class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}