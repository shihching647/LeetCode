/**
 * DP: 手上有沒有股票 + 剩餘可交易次數 + 目前天數 的最大profit
 * 
 * 參考: https://www.youtube.com/watch?v=37s1_xBiqH0&ab_channel=TECHDOSE
 * Time complexity: O(N)
 * Space complexity: O(N)
 */

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // 3D memo, 最大利潤與 
        // 1.手上有沒有股票有關(hasStock, 0:前一天沒買, 1:前一天有買)
        // 2.剩餘可交易數量(remainT)
        // 3.目前天數(index)
        int[][][] memo = new int[2][2][n]; 
        // init memo
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[i].length; j++) {
                for (int k = 0; k < memo[i][j].length; k++) {
                    memo[i][j][k] = -1;
                }
            }
        }
        return maxProfit(prices, 0, 2, 0, memo);
    }
    
    private int maxProfit(int[] prices, int index, int remainT, int hasStock, int[][][] memo) {
        if (index >= prices.length || remainT == 0) {
            return 0;
        }
        
        if (memo[hasStock][remainT - 1][index] != -1) {
            return memo[hasStock][remainT - 1][index];
        }
        
        // 每天其實只能有兩種可能的操作
        // 1. 手上有股票: skip/sell
        // 2. 手上沒股票: skip/buy
        int profit = maxProfit(prices, index + 1, remainT, hasStock, memo); // skip
        if (hasStock == 1) { // 手上有股票 -> sell
            // 賣出時, 剩餘的交易數量才須減一, 且profit要加目前的價格
            profit = Math.max(profit, maxProfit(prices, index + 1, remainT - 1, 0, memo) + prices[index]);
        } else { // 手上沒股票
            // 買進時, 剩餘的交易數量不須減一, 且profit要減目前的價格 -> buy
            profit = Math.max(profit, maxProfit(prices, index + 1, remainT, 1, memo) - prices[index]);
        }
        
        memo[hasStock][remainT - 1][index] = profit;
        return profit;
    }
}