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
        maxProduct(nums, n - 1);
        return ans;
    }
    
    private int[] maxProduct(int[] nums, int i) {
        int min = 0, max = 0;
        if (i == 0) {
            min = max = nums[i];
        } else {
            int[] preResult = maxProduct(nums, i - 1);
            min = preResult[0];
            max = preResult[1];
            if (nums[i] < 0) {
                int temp = min;
                min = max;
                max = temp;
            }
            min = Math.min(min * nums[i], nums[i]);
            max = Math.max(max * nums[i], nums[i]);
        }
        ans = Math.max(ans, max);
        return new int[] {min, max};
    }
}