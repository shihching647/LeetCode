/**
 * Recursion + DP(Top Down)
 * DP(i)定義為 : 從index i 跳到最後所需的最小步數
 * 
 * Time complexity: O(N ^ 2)
 * Space complexity: O(N)
 */

class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n]; // 從index i 跳到最後所需的最小步數
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n - 1] = 0; // base case: 從最後跳到最後需要0步
        jump(nums, 0, dp);
        return dp[0];
    }
    
    private int jump(int[] nums, int start, int[] dp) {
        int n = nums.length;
        if (start >= n - 1) {
            return 0;
        }
        if (dp[start] != Integer.MAX_VALUE)
            return dp[start];
        // 從start ~ start + nums[start]中選最小的步數
        int min = Integer.MAX_VALUE;
        for (int i = start + 1; i <= Math.min(n, start + nums[start]); i++) {
            min = Math.min(min, jump(nums, i, dp));
        }
        // 若有找到, dp[start] = min + 1 (多一步為:從start跳到min的位置)
        if (min != Integer.MAX_VALUE) {
            dp[start] = min + 1;
        }
        return dp[start];
    }
}