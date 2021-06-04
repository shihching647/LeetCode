/**
 * For case like [0,0,0,0,0,0,1] optimization
 * but for case [0,1,2,3,5,5,1] will be worse than the other solution
 * 
 * Algorithm: j紀錄下次遇到nums[i] != 0時要交換的位置
 * 1.All elements before the slow pointer (j) are non-zeroes.
 * 2.All elements between the i and j are zeroes.
 */

class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0; // last non-zero element position 
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != j) {
                    swap(nums, i, j);
                }
                j++;
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}