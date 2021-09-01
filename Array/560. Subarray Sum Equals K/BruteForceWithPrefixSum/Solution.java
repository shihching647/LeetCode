/**
 * Brute force with prefix sum
 * 
 * Time complexity: O(n^2)
 * Space complexity: O(n)
 */


class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = nums[i - 1] + prefixSum[i - 1];
        }
        
        int count = 0;
        for (int l = 1; l < n + 1; l++) {
            for (int r = l; r < n + 1; r++) {
                if (prefixSum[r] - prefixSum[l - 1] == k)
                    count++;
            }
        }
        return count;
    }
}