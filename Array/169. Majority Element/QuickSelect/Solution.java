/**
 * 使用quick select找到最中間的那個數字(中間那個數一定是majority(因為超過一半的數都是majority))
 *
 * Time complexity: O(N)
 * Space complexity: O(1)
 */

class Solution {
    public int findKthLargest(int[] nums, int k) {
        int lo = 0, hi = nums.length - 1;
        int rank = k - 1;
        while (hi > lo) {
            int j = partition(nums, lo, hi);
            if (rank < j) hi = j - 1;
            else if (rank > j) lo = j + 1;
            else return nums[j];
        }
        return nums[lo];
    }
    
    private int partition(int[] nums, int lo, int hi) {
        int pivotIndex = lo + (int) (Math.random() * (hi - lo + 1));
        swap(nums, lo, pivotIndex);
        int pivot = nums[lo];
        int i = lo;
        int j = hi + 1;
        
        while (true) {
            while (nums[++i] > pivot) {
                if (i == hi) break;
            }
            while (nums[--j] < pivot) {
                if(j == lo) break;
            }
            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, lo, j);
        return j;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}