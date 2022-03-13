/**
 * 先排序再找重複(使用Binary Search)
 * 
 * Time complexity: O(NlogN)
 * Space complexity: O(logN) (quick sort for primitive type)
 */
class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] <= mid) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return nums[r];
    }
}