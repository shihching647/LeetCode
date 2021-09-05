/**
 * 嘗試以每個元素nums[i]為起點, 檢查i ~ (i + k)的差有沒有小於等於t
 *
 * Time complexity: O(N*K)
 * Space complexity: O(1)
 */

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length && (j - i) <= k; j++) {
                if (Math.abs((long) nums[i] - (long) nums[j]) <= t)
                    return true;
            }
        }
        return false;
    }
}