/**
 * Recursion + DP(Top Down)
 * DP(i)定義為 : 換成amount=i所需的最小coin數量
 * 
 * Time complexity: O(amount * n)
 * Space complexity: O(amount)
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        coinChange(coins, amount, dp);
        return dp[amount];
    }
    
    private int coinChange(int[] coins, int amount, int[] dp) {
        if (amount < 0)
            return -1;
        
        if (dp[amount] != Integer.MAX_VALUE)
            return dp[amount];
        
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int result = coinChange(coins, amount - coin, dp);
            if (result >= 0 && result < min) {
                min = result + 1;
            }
        }
        dp[amount] = min == Integer.MAX_VALUE ? -1 : min;
        return min;
    }
}