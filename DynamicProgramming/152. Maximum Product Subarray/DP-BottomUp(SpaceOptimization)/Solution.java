/**
 * DP(Bottom up)
 * dp[2][i] 定義為:
 *     dp[0][i]代表0~i中且包含i位置元素的最小乘積
 *     dp[1][i]代表0~i中且包含i位置元素的最大乘積
 * 
 * 參考: https://www.youtube.com/watch?v=gwZm6mIYDfk&ab_channel=HuaHua
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int ans = nums[0];
        // dp[0][i]代表0~i中且包含i位置元素的最小乘積
        // dp[1][i]代表0~i中且包含i位置元素的最大乘積
        int min = nums[0], max = nums[0];
        for (int i = 1; i < n; i++) {
            // 若nums[i]為負數, 則前一個解的最大最小值互換
            if (nums[i] < 0) {
                int temp = min;
                min = max;
                max = temp;
            }
            min = Math.min(min * nums[i], nums[i]);
            max = Math.max(max * nums[i], nums[i]);
            ans = Math.max(ans, max);
        }
        return ans;
    }
}