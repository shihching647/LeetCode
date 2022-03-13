/**
 * DFS + Greedy + Purning(TLE) (最差的情況就是Brute force)
 * 由最大幣值的coin開始換, 並記錄目前最小的答案. 搜索時如果遇到count已經超過最小的量, 就不須搜索下去.
 * 
 * 參考: https://www.youtube.com/watch?v=uUETHdijzkA&ab_channel=HuaHua
 * Time complexity: O(???)
 * Space complexity: O(???)
 */
class Solution {
    
    private int ans = Integer.MAX_VALUE;
    
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        if (amount == 0)
            return 0;
        reverseSort(coins);
        coinChange(coins, 0, amount, 0);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    
    private void coinChange(int[] coins, int index, int amount, int count) {
        int coin = coins[index];
        if (index == coins.length - 1) {  // 最後一種幣值
            if (amount % coin == 0)
                ans = Math.min(ans, count + amount / coin);
        } else {
            // 只有當ans < count + k (已換得數量小於ans, 迴圈才有繼續下去的必要)
            for (int k = amount / coin; k >= 0 && count + k < ans; k--) {
                coinChange(coins, index + 1, amount - coin * k, count + k);
            }
        }
    }
    
    private void reverseSort(int[] a) {
        Arrays.sort(a);
        for (int i = 0; i < a.length / 2; i++) {
            int temp = a[i];
            a[i] = a[a.length - 1 - i];
            a[a.length - 1 - i] = temp;
        }
    }
}