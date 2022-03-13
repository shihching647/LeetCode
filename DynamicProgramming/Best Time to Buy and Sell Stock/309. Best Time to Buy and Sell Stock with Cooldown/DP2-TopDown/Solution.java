/**
 * Top Down: 
 * DP: 第i天可得到的最大profit
 * 基本上就是暴力法 + DP -> 
 * 1. 嘗試第i天購買, 並暴力嘗試在股價比第i天高時賣掉.
 * 2. 第i天不購買
 * -> 上述兩者取max profit
 * 
 * 參考: https://www.youtube.com/watch?v=4wNXkhAky3s&ab_channel=TECHDOSE
 * Time complexity: O(N ^ 2)
 * Space complexity: O(N)
 */

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return maxProfit(prices, 0, dp);
    }
    
    private int maxProfit(int[] prices, int start, int[] dp) {
        if (start >= prices.length)
            return 0;
        if (dp[start] != -1)
            return dp[start];
        // 嘗試在start天買, 並在start天之後且股價比start天高的時候賣掉 
        int profit = 0;
        for (int i = start + 1; i < prices.length; i++) {
            if (prices[i] > prices[start]) {
                profit = Math.max(profit, maxProfit(prices, i + 2, dp) + prices[i] - prices[start]);
            }
        }
        // 嘗試在start天不買
        profit = Math.max(profit, maxProfit(prices, start + 1, dp));
        dp[start] = profit;
        return profit;
    }
}