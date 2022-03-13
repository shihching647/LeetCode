/**
 * 兩個變數: min, profit. 
 * 輪巡每天的價格, 只有兩種情況需要更新:
 * 1. 比min小 -> 更新min (更新完min後, 需要之後才可以賣掉(所以不能更新完min後馬上更新profit), 所以下一輪會發現profit更好, 所以更新profit)
 * 2. profit比較好 -> 更新profit
 * 
 * Time complexity: O(N)
 * Space complexity: O(1)
 */
class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (min > prices[i]) {
                min = prices[i];
            } else if (prices[i] - min > profit) {
                profit = prices[i] - min;
            }
        }
        return profit;
    }
}