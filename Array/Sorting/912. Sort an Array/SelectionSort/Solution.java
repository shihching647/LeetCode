/**
 * Selection sort
 * 
 * Time complexity: O(N^2) (TLE)
 * Space complexity: O(1)
 */

class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (less(nums[j], nums[min])) {
                    min = j;
                }
            } 
            swap(nums, i, min);
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