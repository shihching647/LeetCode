/**
 * Shell sort (with sequence 3x + 1)
 * 
 * Time complexity: O(N ^ 1.5)
 * Space complexity: O(1)
 */

class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        
        int h = 1;
        while (h < n / 3) h = 3 * h + 1; // 1, 4, 13, 40, 121, 364, ...
        
        while (h >= 1) {
            for (int i = h; i < n; i++) { // 從h開始(因為第一個元素已經排好了)
                for (int j = i; j >= h && less(nums[j], nums[j - h]); j -= h) {
                    swap(nums, j, j - h);
                }
            }
            h /= 3;
        }
        return nums;
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