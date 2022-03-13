/**
 * 考慮3個state, noStock(沒有股票), holdStock(持永股票), soldStock(賣完股票的後一天)
 * 
 * 參考: https://www.youtube.com/watch?v=4wNXkhAky3s&ab_channel=TECHDOSE
 * Time complexity: O(N)
 * Space complexity: O(N)
 */

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1)
            return 0;
        int[] noStock = new int[n];
        int[] holdStock = new int[n];
        int[] soldStock = new int[n];
        
        noStock[0] = 0;
        holdStock[0] = -prices[0];
        soldStock[0] = 0;
        
        for (int i = 1; i < n; i++) {
            noStock[i] = Math.max(noStock[i - 1], soldStock[i - 1]);
            holdStock[i] = Math.max(holdStock[i - 1], noStock[i - 1] - prices[i]);
            soldStock[i] = holdStock[i - 1] + prices[i];
        }
        
        return Math.max(noStock[n - 1], soldStock[n - 1]);
    }
}