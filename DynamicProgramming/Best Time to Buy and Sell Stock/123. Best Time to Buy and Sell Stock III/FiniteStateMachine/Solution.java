/**
 * 考慮4個state, s1: 第一次買, s2: 第一次賣, s3: 第二次買, s4: 第二次賣
 * 
 * 
 * 參考: https://www.youtube.com/watch?v=4wNXkhAky3s&ab_channel=TECHDOSE 
 * (Best time to buy and sell stock with cooldown的解法)
 *
 * Time complexity: O(N)
 * Space complexity: O(1)
 */

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1)
            return 0;
        int s1 = -prices[0];
        int s2 = Integer.MIN_VALUE;
        int s3 = Integer.MIN_VALUE;
        int s4 = Integer.MIN_VALUE;
        
        // 原本應該要另外宣告4個變數, tempS1, tempS2, tempS3, tempS4 然後用來計算s1, s2, s3, s4
        // 但因為是取最大值, 所以s1可以確保至少是s1, 故在算s2時可以直接用已經更新過的s1來算.
        // 同理, 算s3可用更新過的s2; 算s4可用更新過的s3.
        for (int i = 1; i < n; i++) {
            s1 = Math.max(s1, -prices[i]);
            s2 = Math.max(s2, s1 + prices[i]);
            s3 = Math.max(s3, s2 - prices[i]);
            s4 = Math.max(s4, s3 + prices[i]);
        }
        return Math.max(0, s4);
    }
}