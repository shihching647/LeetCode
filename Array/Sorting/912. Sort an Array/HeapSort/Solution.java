/**
 * Heap sort
 * 
 * Time complexity: O(NlogN)
 * Space complexity: O(1) (in-place)
 */

class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        
        // 以下操作都是針對index = 1為root
        
        // heapify(從 n / 2的位置開始做sink, (因為大於n/2的位置已經符合heap order))
        for (int i = n / 2; i >= 1; i--) {
            sink(nums, i, n);
        }
        
        // 此時最大的元素在index = 1
        // 所以先swap(1, k) (此時最大的數跑到index = k(已在最終位置), index = 1不符合heap order)
        // 再k--(此時的heap長度要減一)
        // 再sink(1)
        int k = n;
        while (k > 1) {
            swap(nums, 1, k--);
            sink(nums, 1, k);
        }
        return nums;
    }
    
    // 以下操作都是針對index = 1為root
    private void sink(int[] nums, int k, int n) { // sink要多帶一個參數n用來指定目前heap的大小
        while (2 * k <= n) {
            int child = 2 * k;
            if (child < n && less(nums, child, child + 1)) child++; // 注意child < n這個條件
            if (!less(nums, k, child)) break; // 當發現parent沒有小於比較大的child時, break
            swap(nums, k, child);
            k = child;
        }
    }
    
    // 以下操作要off by 1, 因為上面呼叫都是針對index = 1為root, 但是實際上root在index = 0
    // off by 1
    private boolean less(int[] nums, int i, int j) {
        return nums[i - 1] < nums[j - 1];
    }
    
    // off by 1
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i - 1];
        nums[i - 1] = nums[j - 1];
        nums[j - 1] = temp;
    }
}