/**
 * Bubble sort:
 * 將最大的樹移到最後一個, 第二大的數移到倒數第二個...
 * 
 * Time complexity: O(N^2) (TLE)
 * Space complexity: O(1)
 */

class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        for (int i = n - 1; i > 0; i--) { // i為本回合要移動到的位置(從最後一個位置開始)
            boolean isSwap = false;
            for (int j = 0; j < i; j++) { // 從第一個元素開始, 每次與隔壁比較, 若nums[i]比較nums[i+1]大就換位置
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    isSwap = true;
                }
            }
            if (!isSwap)
                break;
        }
        return nums;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}