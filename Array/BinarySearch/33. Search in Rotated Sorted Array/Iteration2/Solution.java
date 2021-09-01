/**
 * Iteration version
 * 想法：每次切一半至少會有一半是排好序的, 檢查target是否在排好序的範圍, 是的話就搜尋排好序的那一半, else搜尋另一半
 *
 * Time complexity: O(logN)
 * Space complexity: O(1)
 *
 */
class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int lo = 0, hi = n - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            
            // left part is sorted
            if (nums[lo] <= nums[mid]) {
                if (target >= nums[lo] && target <= nums[mid]) { // 如果target介於left之中(sorted part)
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else { // right part is sorted
                if (target >= nums[mid] && target <= nums[hi]) {// 如果target介於right之中(sorted part)
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }    
            }
        }
        return -1;
    }
}