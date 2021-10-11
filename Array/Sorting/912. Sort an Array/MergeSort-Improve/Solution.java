/**
 * Merge sort - improvement(aux, nums腳色互換)
 * 
 * Time complexity: O(NlogN)
 * Space complexity: O(N)
 */

class Solution {
    public int[] sortArray(int[] nums) {
        int[] aux = new int[nums.length];
        System.arraycopy(nums, 0, aux, 0, nums.length);
        mergeSort(aux, nums, 0, nums.length - 1);
        return nums;
    }
    
    private void mergeSort(int[] nums, int[] aux, int l, int r) {
        if (l >= r) {
            return;
        } 
        int mid = l + (r - l) / 2;
        mergeSort(aux, nums, l, mid);
        mergeSort(aux, nums, mid + 1, r);
        merge(nums, aux, l, mid, r);
    }
    
    private void merge(int[] nums, int[] aux, int l, int mid, int r) {
        int n = nums.length;
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                aux[k] = nums[j++];
            } else if (j > r) {
                aux[k] = nums[i++];
            } else if (less(nums[i], nums[j])) {
                aux[k] = nums[i++];
            } else {
                aux[k] = nums[j++];
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