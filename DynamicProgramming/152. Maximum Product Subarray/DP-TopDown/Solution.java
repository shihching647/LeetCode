/**
 * DP(Top down)
 * dp[2][i] 定義為:
 *     dp[0][i]代表0~i中且包含i位置元素的最小乘積
 *     dp[1][i]代表0~i中且包含i位置元素的最大乘積
 * 
 * 參考: https://www.youtube.com/watch?v=gwZm6mIYDfk&ab_channel=HuaHua
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
class Solution {
    int ans = Integer.MIN_VALUE;
    
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            dp[i] = null;
        }
        maxProduct(nums, n - 1, dp);
        return ans;
    }
    
    private int[] maxProduct(int[] nums, int i, int[][] dp) {
        if (i == 0) {
            ans = Math.max(ans, nums[0]);
            return new int[]{nums[0], nums[0]};
        }
        if (dp[i] != null)
            return dp[i];
        
        // 取得i - 1的結果
        int[] result = maxProduct(nums, i - 1, dp);
        int min = result[0], max = result[1];
        if (nums[i] < 0) {
            int temp = min;
            min = max;
            max = temp;
        }
        min = Math.min(min * nums[i], nums[i]);
        max = Math.max(max * nums[i], nums[i]);
        dp[i] = new int[]{min, max};
        ans = Math.max(ans, max);
        return dp[i];
    }
}