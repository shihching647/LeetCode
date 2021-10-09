/**
 * Brute force
 * Time complexity: O(N^2)
 * Space complexity: O(1)
 *
 */
class Solution {
    public int countKDifference(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) == k)
                    count++;
            }
        }
        return count;
    }
}