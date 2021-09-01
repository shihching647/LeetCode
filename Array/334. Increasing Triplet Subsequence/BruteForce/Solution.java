/**
 * Brute Force
 * 
 * Time complexity: O(n^3)
 * Space complexity: O(1)
 */

class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] < nums[j] && nums[j] < nums[k])
                        return true;
                }
            }
        }
        return false;
    }
}