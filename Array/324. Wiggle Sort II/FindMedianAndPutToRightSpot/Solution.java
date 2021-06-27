/**
 * 先用quicl select找到median
 * 在iterate nums[], 
 * S的部分(even位置)從後面開始放, L的部分(odd的位置)從1開始放
 * 最後剩餘的odd, even都補median
 * 便可得到答案
 * 
 * 參考:https://leetcode.com/problems/wiggle-sort-ii/discuss/77682/Step-by-step-explanation-of-index-mapping-in-Java
 * 
 * 
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int median = findKthLargest(nums, (n + 1) / 2);
        int[] temp = new int[n]; // 用來暫存解答
        
        // iterate nums[]
        // 將nums[i] < medain的放入even的位置 (從最後面開始)
        // 將nums[i] > median的放入odd的位置  (從index = 1開始)
        int odd = 1;
        int even = n % 2 == 0 ? n - 2 : n - 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] > median) {
                temp[odd] = nums[i];
                odd += 2;
            } else if (nums[i] < median) {
                temp[even] = nums[i];
                even -= 2;
            }
        }
        // odd不足n的補medain
        while (odd < n) {
            temp[odd] = median;
            odd += 2;
        }
        // even不到0的也補median
        while (even >= 0) {
            temp[even] = median;
            even -= 2;
        }
        // copy from temp[] to nums[]
        System.arraycopy(temp, 0, nums, 0, n);
    }

    // LeetCode 215. Kth Largest Element in an Array (quick select)    
    private int findKthLargest(int[] nums, int k) {
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
        // randomly choose pivot
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