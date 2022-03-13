/**
 * DP: 手上有沒有股票 + 使否為coolDown + 目前天數 的最大profit
 * (參考123. Best Time to Buy and Sell Stock III的DP解法)
 * 
 * Time complexity: O(N)
 * Space complexity: O(N)
 */

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[2][2][n];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                for (int k = 0; k < dp[i][j].length; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return maxProfit(prices,0, 0, 0, dp);
    }
    
    private int maxProfit(int[] prices, int index, int hasShare, int cooldown, int[][][] dp) {
        if (index >= prices.length)
            return 0;
        if (dp[hasShare][cooldown][index] != -1)
            return dp[hasShare][cooldown][index];
        int profit = maxProfit(prices, index + 1, hasShare, 0, dp); // skip
        if (hasShare == 0 && cooldown != 1) {
            profit = Math.max(profit, maxProfit(prices, index + 1, 1, 0, dp) - prices[index]); // buy
        } else if (hasShare == 1) {
            profit = Math.max(profit, maxProfit(prices, index + 1, 0, 1, dp) + prices[index]); // sell
        }
        dp[hasShare][cooldown][index] = profit;
        return profit;
    }
}