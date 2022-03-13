/**
 * Bottom Up:
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
        if (n <= 1)
            return 0;
        int[] dp = new int[n]; // 第i天買進, 可得到的最大獲利
        int ans = 0;
        // base case
        dp[n - 1] = 0;
        dp[n - 2] = Math.max(0, prices[n - 1] - prices[n - 2]);
        
        // 找到所有i
        for (int i = n - 3; i >= 0; i--) {
            // 嘗試在第i天買進, 第j天賣掉
            // 因為在n - 1天賣, 跟n - 2賣 沒辦法再買, 所以若放進下面for迴圈的話, dp[j + 2]會index會out od bound, 故要獨立考慮.
            int profit = Math.max(prices[n - 1] - prices[i], prices[n - 2] - prices[i]);
            for (int j = i + 1; j < n - 2; j++) {
                if (prices[j] > prices[i]) {
                    profit = Math.max(profit, dp[j + 2] + prices[j] - prices[i]);
                }
            }
            // 第i天不操作
            profit = Math.max(profit, dp[i + 1]);
            dp[i] = profit;
        }
        
        return dp[0];
    }
}