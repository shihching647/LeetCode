/**
 * Brute force:
 * 
 * Time complexity: O(n^2)
 * Space complexity: O(1)
 */


class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        for (int l = 0; l < n; l++) {
            int count = 0;
            for (int r = l; r < n; r++) {
                count += nums[r];
                if (count == k) ans++;
            }
        }
        return ans;
    }
}