/**
 * Divide and Conquer:
 * 
 * 
 * 參考: https://www.youtube.com/watch?v=_evw8n7rGbU&list=PLOAQYZPRn2V7lSunztJ4h0Sb0ejUA4Juq&index=11&t=1267s&ab_channel=VivianNTUMiuLab
 * Time complexity: O(NlogN)
 * Space complexity: O(logN)
 */
class Solution {
    public int maxSubArray(int[] nums) {
        return maxSubArray(nums, 0, nums.length - 1);
    }
    
    private int maxSubArray(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }
        if (start > end) {
            return Integer.MIN_VALUE;
        }
        
        int mid = start + (end - start) / 2;
        int leftAns = maxSubArray(nums, start, mid - 1); // case1: 整個範圍在left
        int rightAns = maxSubArray(nums, mid + 1, end);  // case2: 整個範圍在right
        
        // case3: 範圍包含mid
        // 往左找leftSumMax最大
        int leftSum = 0;
        int leftSumMax = 0;
        for (int i = mid - 1; i >= start; i--) {
            leftSum += nums[i];
            leftSumMax = Math.max(leftSumMax, leftSum);
        }
        // 往右找rightSumMax最大
        int rightSum = 0;
        int rightSumMax = 0;
        for (int i = mid + 1; i <= end; i++) {
            rightSum += nums[i];
            rightSumMax = Math.max(rightSumMax, rightSum);
        }
        
        // 回傳case1, case2, case3的max
        return Math.max(Math.max(leftAns, rightAns), leftSumMax + nums[mid] + rightSumMax);
    }
}