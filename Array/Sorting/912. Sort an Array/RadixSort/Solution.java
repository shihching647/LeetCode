/**
 * Radix sort
 * 
 * Time complexity: O(N)
 * Space complexity: O(R)
 */

class Solution {
    private static final int R = 10;
    private static final int OFF_SET = 50000;
    
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        // add OFF_SET(讓全部數字都 >= 0)
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            nums[i] += OFF_SET;
            max = Math.max(max, nums[i]);
        }
        
        int[] aux = new int[n];
        int factor = 1;
        while (factor <= max) {
            radixSort(nums, aux, factor);
            factor *= 10;
        }
        
        for (int i = 0; i < n; i++) 
            nums[i] -= OFF_SET;
        
        return nums;
    }
    
    private void radixSort(int[] nums, int[] aux, int factor) {
        int n = nums.length;
        int[] count = new int[R + 1];
        for (int i = 0; i < n; i++) 
            count[((nums[i] / factor) % R) + 1]++; // (nums[i] / factor) % R
        
        for (int r = 0; r < R; r++)
            count[r + 1] += count[r];
        
        for (int i = 0; i < n; i++)
            aux[count[((nums[i] / factor) % R)]++] = nums[i];
        
        System.arraycopy(aux, 0, nums, 0, n);
    }
}