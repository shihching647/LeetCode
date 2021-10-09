/**
 * 使用HashMap紀錄出現目前到現在各個數字出現的頻率
 * 
 * Time complexity: O(N)
 * Space complexity: O(R) (R個不同的數字)
 *
 */
class Solution {
    public int countKDifference(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int num : nums) {
            count += map.getOrDefault(num + k, 0) + map.getOrDefault(num - k, 0);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return count;
    }
}