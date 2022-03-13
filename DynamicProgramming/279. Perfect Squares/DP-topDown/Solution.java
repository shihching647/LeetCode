/**
 * DP (Top Down): 
 * dp[i] = 組成數字i需用到的最小平方數的個數
 * 
 * 參考: https://www.youtube.com/watch?v=1xfx6M_GqFk&ab_channel=TECHDOSE
 * Time Complexity: O(n√n)
 * Space Complexity: O(n)
 */

class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        return numSquares(n, dp);
    }
    
    private int numSquares(int n, int[] dp) {
        if (n <= 3) {
            return n;
        }
        if (dp[n] > 0) 
            return dp[n];
        int num = n;
        // 嘗試1^2, 2^2, 3^2...
        for (int i = 1; i * i <= n; i++) {
            num = Math.min(num, numSquares(n - i * i, dp) + 1);
        }
        dp[n] = num;
        return dp[n];
    }
}