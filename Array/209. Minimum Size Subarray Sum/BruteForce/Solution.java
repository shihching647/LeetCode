/**
 * Brute force
 * Time complexity: O(n^2)
 * Space complexity: O(1)
 */

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            int l = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                l++;
                if (sum >= target) {
                    minLength = Math.min(l, minLength);
                    break;
                }
            } 
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}