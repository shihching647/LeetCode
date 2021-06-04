/**
 * One Pointer:
 * 用start去控制起始位置，當nums加到符合target時, 嘗試縮小範圍(增加start), 當扣到sum < target時, 在前進到下一個num
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int start = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                minLength = Math.min(minLength, i - start + 1);
                sum -= nums[start++];
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}