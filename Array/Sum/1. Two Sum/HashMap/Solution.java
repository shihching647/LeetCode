/**
 * Use a hash map save (target - nums[i], i).
 * Iterate nums,
 * if you can find nums[i] in map, return i, map.get(nums[i])
 * else insert (target - nums[i], i) into map
 * 
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) != null) {
                return new int[]{i, map.get(nums[i])};
            } else {
                map.put(target - nums[i], i);
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}