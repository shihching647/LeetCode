/**
 * Merge sort
 * 
 * Time complexity: O(NlogN)
 * Space complexity: O(N)
 */

class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        mergeSort(nums, 0, r);
        return nums;
    }
    
    private void mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        } 
        int mid = l + (r - l) / 2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        merge(nums, l, mid, r);
    }
    
    private void merge(int[] nums, int l, int mid, int r) {
        int n = nums.length;
        int[] temp = new int[n];
        System.arraycopy(nums, 0, temp, 0, n);
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                nums[k] = temp[j++];
            } else if (j > r) {
                nums[k] = temp[i++];
            } else if (less(temp[i], temp[j])) {
                nums[k] = temp[i++];
            } else {
                nums[k] = temp[j++];
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