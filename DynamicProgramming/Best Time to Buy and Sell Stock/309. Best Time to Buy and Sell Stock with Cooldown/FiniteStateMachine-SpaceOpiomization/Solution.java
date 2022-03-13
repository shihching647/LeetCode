/**
 * 考慮3個state, noStock(沒有股票), holdStock(持永股票), soldStock(賣完股票的後一天)
 * 
 * 參考: https://www.youtube.com/watch?v=4wNXkhAky3s&ab_channel=TECHDOSE
 * Time complexity: O(N)
 * Space complexity: O(1)
 */

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1)
            return 0;
        
        int noStock = 0;
        int holdStock = -prices[0];
        int soldStock = 0;
        int tempNoStock = noStock;
        int tempHoldStock = holdStock;
        int tempSoldStock = soldStock;
        
        for (int i = 1; i < n; i++) {
            tempNoStock = noStock;
            tempHoldStock = holdStock;
            tempSoldStock = soldStock;
            noStock = Math.max(tempNoStock, tempSoldStock);
            holdStock = Math.max(tempHoldStock, tempNoStock - prices[i]);
            soldStock = tempHoldStock + prices[i];
            
        }
        
        return Math.max(noStock, soldStock);
    }
}