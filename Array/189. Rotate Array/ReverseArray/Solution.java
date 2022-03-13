/**
 * Reverse array
 * 
 * Time complexity: O(N)
 * Space complexity: O(1)
 */

class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int offset = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, offset - 1);
        reverse(nums, offset, n - 1);
    }
    
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j]; 
        nums[j] = temp;
    }
}