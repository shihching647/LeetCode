/**
 * 因為可以無限次交易, 所以只要發現隔天的股價高於今天. 就今天買隔天賣, 賺到該筆profit.
 * 
 * Time complexity: O(N)
 * Space complexity: O(1)
 */

class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}