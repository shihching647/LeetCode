/**
 * Bottom-up merge sort
 * 
 * Time complexity: O(NlogN)
 * Space complexity: O(N)
 */

class Solution {
    public int[] sortArray(int[] nums) {
        int[] aux = new int[nums.length];
        System.arraycopy(nums, 0, aux, 0, nums.length);
        int n = nums.length;
        for (int size = 1; size < n; size *= 2) {
            for (int lo = 0; lo < n - size; lo += 2 * size) {
                merge(nums, aux, lo, lo + size - 1, Math.min(lo + 2 * size - 1, n - 1));
            }
        }
        return nums;
    }
    
    private void merge(int[] nums, int[] aux, int l, int mid, int r) {
        int n = nums.length;
        System.arraycopy(nums, 0, aux, 0, n);
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                nums[k] = aux[j++];
            } else if (j > r) {
                nums[k] = aux[i++];
            } else if (less(aux[i], aux[j])) {
                nums[k] = aux[i++];
            } else {
                nums[k] = aux[j++];
            }
        }
    }
     
    private boolean less(int a, int b) {
        return a < b;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}