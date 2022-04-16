/**
 * DP(Bottom up)
 * dp[i] 定義為: 從0到i的array中, 包含i元素的, subarray的最大和.
 * 
 * 參考: https://www.youtube.com/watch?v=7J5rs56JBs8&ab_channel=HuaHua
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

class Solution {
    public int maxSubArray(int[] nums) {
        // dp[i] 定義為: 從0到i的array中, 包含i元素的, subarray的最大和.
        int dp = nums[0]; 
        int max = dp;
        for (int i = 1; i < nums.length; i++) {
            // 從(前一個的最大和 + 自己, 自己)選較大的. (含意: 若前一個和為負數, 直接從自己當作subarray的起點)
            dp = Math.max(dp + nums[i], nums[i]);
            max = Math.max(max, dp);
        }
        return max;
    }
}