/**
 * Algorithm:
 * 先從最後往前找, 找到最大的permutation (就是照descending排列) index位置i
 * (換句話說: 從i之後的的元素已經是最大的permutation)
 * 
 * 下一個permutation就是從i之後的元素找, 找到剛好大於a[i]的元素a[j], 交換a[i]跟a[j]
 * 然後再把i + 1之後的元素reverse(變成最小的permutation), 即為答案
 *
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
class Solution {
    public void nextPermutation(int[] nums) {
    
        // 找到不滿足descending排列的index:i
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) { // nums[i + 1] <= nums[i], 不能只有 <
            i--;
        }
        
        // 若是有找到, 再從最後開始往前找, 找到剛好大於nums[i]的數a[j], swap(i,j)
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[i] >= nums[j]) { 
                j--;
            }
            swap(nums, i, j);
        }
        // 將i + 1之後的元素reverse
        reverse(nums, i + 1);
    }
    
    private void reverse(int[] nums, int i) {
        int j = nums.length - 1;
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
