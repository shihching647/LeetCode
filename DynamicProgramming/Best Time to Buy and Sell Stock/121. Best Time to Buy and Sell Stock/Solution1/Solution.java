/**
 * 兩個變數: min, profit. 輪巡每天的價格, 與min取最小值, 與profit取最大值. 
 * 
 * Time complexity: O(N)
 * Space complexity: O(1)
 */
class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            profit = Math.max(profit, prices[i] - min);
        }
        return profit;
    }
}