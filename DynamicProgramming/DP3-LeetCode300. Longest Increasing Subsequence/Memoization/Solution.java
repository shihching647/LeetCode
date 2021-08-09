/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

/**
 * 
 * 參考: https://www.youtube.com/watch?v=7DKFpWnaxLI&ab_channel=HuaHua
 * 
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 * 
 **/
class Solution {
        
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) 
            return 0;
        
        int[] memo = new int[n];
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            maxLength = Math.max(maxLength, lengthOfLIS(nums, i, memo));
        }
        return maxLength;
    }
    
    // length of LIS ends with nums[r]
    private int lengthOfLIS(int[] nums, int r, int[] memo) {
        // base case
        if (r == 0)
            return 1;
        
        // look up memo
        if (memo[r] > 0)
            return memo[r];
        
        int length = 1;
        for (int i = 0; i < r; i++) {
            // 只有當nums[r] > nums[i]時才需要遞迴呼叫, 因為當nums[r] < nums[i]時, 以nums[r]當作end不是一個解
            if (nums[r] > nums[i]) { 
                length = Math.max(length, lengthOfLIS(nums, i, memo) + 1);
            }
        }
        memo[r] = length; // 紀錄在memo
        return length;
    }
    
}