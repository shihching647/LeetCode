/**
 * 因為只能發生兩次交易, 所以每個i為分界點, 考慮左邊發生一次跟右邊發生一次的最大profit
 * 1. 先求出每個i左邊發生一次交易的最大profit array
 * 2. 再求出每個i右邊發生一次交易的最大profit array
 * 3. 輪巡每個i, 取兩者和的最大值
 * 
 * 參考: https://www.youtube.com/watch?v=37s1_xBiqH0&ab_channel=TECHDOSE
 * Time complexity: O(N)
 * Space complexity: O(1)
 */

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] left = new int[n]; // 第i天的左邊發生一次交易最大的profit
        int[] right = new int[n];// 第i天的右邊發生一次交易最大的profit
        
        // left (先買再賣)
        int min = prices[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        
        // right (現賣再買)
        int max = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i], max - prices[i]);
            max = Math.max(max, prices[i]);
        }
        
        // 嘗試第i天左邊(0 ~ i - 1)與右邊(i ~ 最後)各發生一次交易, 找出最大的profit
        int profit = right[0]; // right[0] 跟 left[n - 1]是一樣的, 都代表第一天買,最後一天賣. 所以只需要考慮一個就好.
        for (int i = 1; i < n; i++) {
            profit = Math.max(profit, left[i - 1] + right[i]);
        }
        return profit;
    }
}