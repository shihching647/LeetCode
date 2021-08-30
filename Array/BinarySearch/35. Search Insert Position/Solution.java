/**
 * Binary search
 *
 * Why does return lo rather than hi?
 * 
 * 找不到時有兩種情況:
 * 1. lo == mid == hi :
 *    當 nums[mid] < target -> lo = mid + 1, target應該insert在mid + 1的位置(即為lo), 而不是hi(此時hi為mid)
 *    當 nums[mid] > target -> hi = mid - 1, target應該insert在mid的位置即為(lo), 而不是hi (此時hi為mid - 1)
 * 2. lo == mid == hi - 1 :
 *    當 nums[mid] < target -> lo = mid + 1, 回到case 1
 *    當 nums[mid] > target -> hi = mid - 1, target應該insert在mid的位置即為(lo), 而不是hi (此時hi為mid - 1)
 *
 *
 * Time complexity: O(logN)
 * Space complexity: O(1)
 */

class Solution {
    public int searchInsert(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            // int mid = (lo + hi) / 2; -> might cause overflow
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < target)
                lo = mid + 1;
            else if (nums[mid] > target)
                hi = mid - 1;
            else 
                return mid;
        }
        return lo; // return lo
    }
}