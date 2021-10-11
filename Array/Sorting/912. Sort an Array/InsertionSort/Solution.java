/**
 * Insertion sort
 * 
 * Time complexity: O(N^2) (TLE)
 * Space complexity: O(1)
 */

class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && less(nums[j], nums[j - 1]); j--) {
                swap(nums, j, j - 1);
            }
        }
        return nums;
    }
    
    private boolean less(int a, int b) {
        return a < b;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}