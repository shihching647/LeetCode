/**
 * Recursion + DP(Bottom Up)
 * DP(i)定義為 : 從index i 跳到最後所需的最小步數
 * 
 * 參考: https://www.youtube.com/watch?v=BRnRPLNGWIo&ab_channel=AlgorithmsMadeEasy
 * Time complexity: O(N ^ 2)
 * Space complexity: O(N)
 */

class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n]; // 從index i 跳到最後所需的最小步數
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            int min = Integer.MAX_VALUE;
            for (int j = i + 1; j <= Math.min(n - 1, i + nums[i]); j++) {
                min = Math.min(min, dp[j]);
            }
            if (min != Integer.MAX_VALUE) {
                dp[i] = min + 1;
            }
        }
        return dp[0];
    }
}