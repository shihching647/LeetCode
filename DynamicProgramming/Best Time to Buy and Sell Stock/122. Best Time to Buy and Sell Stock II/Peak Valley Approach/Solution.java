/**
 * 找到local低點, 找到local高點 -> profit += (高點 - 低點)
 * 
 * Time complexity: O(N)
 * Space complexity: O(1)
 */

class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int peak = prices[0], valley = prices[0];
        int i = 0;
        int n = prices.length;
        // 必須先找最低點買進, 再找最高點賣出. (因為是先買後賣)
        while (i < n - 1) { // 這邊是 i < n - 1, 因為裡面是prices[i + 1]
            // 找到最低點
            while (i < n - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            valley = prices[i];
            // 找到最高點
            while (i < n - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            peak = prices[i];
            profit += (peak - valley);
        }
        return profit;
    }
}