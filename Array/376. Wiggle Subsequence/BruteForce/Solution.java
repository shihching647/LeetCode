/**
 * Brute force把n!個排列組合全部嘗試過
 * Time complexity: O(n!)
 * Space complexity: O(n) 
 */

class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        return 1 + Math.max(calculate(nums, 0, true), calculate(nums, 0, false));
    }
    
    private int calculate(int[] nums, int index, boolean isUp) {
        int max = 0;
        for (int i = index + 1; i < nums.length; i++) {
            if ((isUp && nums[i] > nums[i - 1]) || (!isUp && nums[i] < nums[i - 1]))
                max = Math.max(max, 1 + calculate(nums, i, !isUp));
        }
        return max;
    }
}