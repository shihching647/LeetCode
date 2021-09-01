/**
 * 記錄Iterate目前最小的數min, 與第二小的數字mid
 * 每次更新都update這兩個數, 當發現某一nums[i]大於這兩個數時, 即找到解
 * 
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= min) {
                min = nums[i];
            } else if (nums[i] <= mid) {
                mid = nums[i];
            } else {
                return true;
            }
        }
        return false;
    }
}