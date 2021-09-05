/**
 * 使用HashMap
 *
 * Time complexity: O(N)
 * Space complexity: O(N)
 */

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 若包含nums[i] && 滿足答案需求(j - i <= k)
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}