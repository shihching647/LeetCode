/**
 * 使用DP. DP[t] = target為t的所有組合.
 *
 * Time complexity: O(???)
 * Space complexity: O(???)
 *
 */
class Solution {
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int[] dp = new int[target + 1];
        dp[0] = 0;
        for (int t = 1; t < dp.length; t++) {
            int count = 0;
            for (int i = 0; i < nums.length && nums[i] <= t; i++) {
                if (nums[i] == t) count++;
                count += dp[t - nums[i]];
            }
            dp[t] = count;
        }
        return dp[target];
    }
}