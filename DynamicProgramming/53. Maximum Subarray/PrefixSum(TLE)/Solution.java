/**
 * Brute force + prefixSum:
 * 先預算prefixSum. 再暴力法嘗試所有區間, 找出最大的區間和.
 * 
 * Time complexity: O(N ^ 2) (TLE)
 * Space complexity: O(N)
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++)
            prefixSum[i + 1] += prefixSum[i] + nums[i];
        
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                max = Math.max(max, prefixSum[j] - prefixSum[i]);
            }
        }
        return max;
    }
}