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
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])) 
                return new int[]{map.get(numbers[i]) + 1, i + 1}; // 順序不可換, index小的要在前面(先放到map的是index比較小的)
            else
                map.put(target - numbers[i], i);
        }
        throw new IllegalArgumentException("No solution are found.");
    }
}