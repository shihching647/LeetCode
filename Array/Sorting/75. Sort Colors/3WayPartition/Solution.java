/**
 * 3-way partition

 * Time complexity: O(N)
 * Space complexity: O(1)
 */

class Solution {
    public void sortColors(int[] nums) {
        // 3-way partition, pivot == 1
        int lo = 0, hi = nums.length - 1;
        int i = lo;
        int pivot = 1;
        while (i <= hi) {
            if (nums[i] < pivot) 
                swap(nums, i++, lo++);
            else if (nums[i] > pivot)
                swap(nums, i, hi--);
            else
                i++;
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}