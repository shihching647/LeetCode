/**
 * Binary search
 * 用一個pos紀錄要插入的位置,叫好理解
 *
 * Time complexity: O(logN)
 * Space complexity: O(1)
 */

class Solution {
    public int searchInsert(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        int pos = nums.length;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < target) {
                pos = mid + 1; // 插在mid右邊
                lo = mid + 1;
            } else if (nums[mid] > target) {
                pos = mid; // 插在mid
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return pos;
    }
}