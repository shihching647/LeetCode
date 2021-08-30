/**
 * Iteration version
 * 
 * 參考:https://www.youtube.com/watch?v=dVXy6hmE_0U&ab_channel=Errichto
 *
 * Time complexity: O(logN)
 * Space complexity: O(1)
 *
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = findFirstElementGraterOrEqual(nums, target);
        int end = findFirstElementGraterOrEqual(nums, target + 1) - 1; // 找target + 1的前一個位置
        if (start <= end) {
           return new int[]{start, end};
        }
        return new int[]{-1, -1};
    }
    
    private int findFirstElementGraterOrEqual(int[] nums, int x) {
        int n = nums.length;
        int lo = 0, hi = n - 1;
        int ans = n; // 初始位置改成n, 考慮[1,2,3], 找x = 4的清況 -> 沒找到回傳index:3
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] >= x) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }
}