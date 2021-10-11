/**
 * Quick sort
 * 
 * Time complexity: O(NlogN)
 * Space complexity: O(logN)
 */

class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        quickSort(nums, 0, n - 1);
        return nums;
    }
    
    private void quickSort(int[] nums, int lo, int hi) {
        if (hi <= lo)
            return;
        int pivotIndex = lo + (int) Math.random() * (hi - lo + 1);
        swap(nums, lo, pivotIndex);
        int lt = lo, gt = hi;
        int i = lo + 1;
        while (i <= gt) {
            if (nums[lt] > nums[i]) {
                swap(nums, lt++, i++);
            } else if (nums[lt] < nums[i]) {
                swap(nums, i, gt--);
            } else {
                i++;
            }
        }
        quickSort(nums, lo, lt - 1);
        quickSort(nums, gt + 1, hi);
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}