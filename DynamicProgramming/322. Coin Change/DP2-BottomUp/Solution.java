/**
 * Recursion + DP(Bottom up): 
 * 與前一種DP不同的想法, 此版DP是先找到一種coin最小的數量, 再找兩種coin最小的數量...(外圈for是iterate coins)
 * 
 * DP(i)定義為 : 換成amount=i所需的最小coin數量
 *
 * 參考: https://www.youtube.com/watch?v=uUETHdijzkA&ab_channel=HuaHua
 * Time complexity: O(amount * n)
 * Space complexity: O(amount)
 */

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // 因為coin最小的幣值是1, 所以不可能數量最大不會超過amount + 1
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = 1; i < dp.length; i++) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        // 當數量 >= amount + 1時候, 代表沒有解答
        return dp[amount] >= amount + 1 ? -1 : dp[amount];
    }
}