/**
 * 先將nums排序, 再取從0開始取window長度為k的數字差, 一路到最後, 找最小值.
 * 
 * Time complexity: O(NlogN)
 * Space complexity: O(1)
 *
 */
class Solution {
    public int minimumDifference(int[] nums, int k) {
        if (nums.length < k)
            return 0;
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for (int i = 0; (i + k - 1) < nums.length; i++) {
            min = Math.min(min, nums[i + k - 1] - nums[i]);
        }
        return min;
    }
}