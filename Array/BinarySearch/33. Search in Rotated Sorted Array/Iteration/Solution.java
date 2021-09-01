/**
 * Iteration version
 * 做兩次binary search:
 * 1. 先找到最小的位置pos
 * 2. 使用還原的index做binary search
 *
 * Time complexity: O(logN)
 * Space complexity: O(1)
 *
 */
class Solution {
    public int search(int[] nums, int target) {
        // 1. 先找到最小的位置pos
        int n = nums.length;
        int lo = 0, hi = n - 1;
        int pos = n;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] <= nums[n - 1]) {
                pos = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        
        // 2. 使用還原的array做binary search
        lo = 0; hi = n - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int index = (mid + pos) % n; // 還原的index
            if (nums[index] == target) {
                return index; // 因為nums[index] == target, 所以回傳index
            } else if (nums[index] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }
}