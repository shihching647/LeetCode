/**
 * Iteration version2 (比較好理解)
 * 參考: https://www.youtube.com/watch?v=GU7DpgHINWQ (約18分鐘處)
 * 考慮一個陣列a, 檢查每個元素a[i]是否大於等於第一個元素a[0]
 * a = [4, 5, 6, 7, 0, 1, 2]
 *     [T, T, T, T, F, F, F]
 * 此題可以解釋成, 找到第一個F的位置.
 * 但若為未rotate的陣列, 會變成沒有F
 * a = [0, 1, 2, 4, 5, 6, 7]
 *     [T, T, T, T, T, T, T]
 * 
 * 故需要改成 -> 檢查每個元素a[i]是否小於等於最後一個元素a[n - 1], 找到第一個T的位置.
 * a = [4, 5, 6, 7, 0, 1, 2]
 *     [F, F, F, F, T, T, T]
 * 
 * a = [0, 1, 2, 4, 5, 6, 7]
 *     [T, T, T, T, T, T, T]
 *
 * 算法: 如何找到第一個T的位置
 * 找到mid, 檢查該a[mid] <= a[n - 1], 
 * true -> 紀錄該位置, 在往左邊找有沒有更小的T
 * false -> 往右邊找
 * 
 * Time complexity: O(logN)
 * Space complexity: O(1)
 *
 */
class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int lo = 0, hi = n - 1;
        int ans = -1; // 最佳的答案
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] <= nums[n - 1]) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return nums[ans];
    }
}