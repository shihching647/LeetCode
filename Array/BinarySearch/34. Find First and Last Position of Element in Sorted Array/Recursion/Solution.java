/**
 * Resursion version
 * 
 * Time complexity: O(lonN) 
 * Space complexity: O(logN)
 *
 */
class Solution {
    
    private int start = -1, end = -1;
    
    public int[] searchRange(int[] nums, int target) {
        searchRange(nums, target, 0, nums.length - 1);
        return new int[]{start, end};
    }
    
    private void searchRange(int[] nums, int target, int lo, int hi) {
        if (lo > hi) 
            return;
        if (nums[lo] == target) {
            if (start == -1)
                start = lo;
            else
                start = Math.min(start, lo);
        }
        
        if (nums[hi] == target) {
            end = Math.max(end, hi);
        }
        
        if (nums[lo] == nums[hi])
            return;
        
        int mid = lo + (hi - lo) / 2;
        searchRange(nums, target, lo, mid); // 小的那邊用[lo, mid], 避免算到lo = 0, mid = 1時會導致stackOverFlow
        searchRange(nums, target, mid + 1, hi); // 大的那邊用[mid + 1, hi]
    }
}