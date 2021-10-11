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
        int j = partition(nums, lo, hi);
        quickSort(nums, lo, j - 1);
        quickSort(nums, j + 1, hi);
    }
    
    private int partition(int[] nums, int lo, int hi) {
        int pivotIndex = lo + (int) Math.random() * (hi - lo + 1);
        swap(nums, lo, pivotIndex);
        int i = lo, j = hi + 1;
        while (true) {
            while (less(nums[++i], nums[lo])) {
                if (i == hi) break;
            }
            
            while (less(nums[lo], nums[--j])) {
                if (j == lo) break;
            }
            if (i >= j)
                break;
            swap(nums, i, j);
        }
        swap(nums, j, lo);
        return j;
    }
    
    private boolean less(int a, int b) {
        return a < b;
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}