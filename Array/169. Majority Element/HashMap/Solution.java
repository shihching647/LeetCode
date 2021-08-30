/**
 * 使用HashMap紀錄每個數字出現的次數, 當次數 > n / 2時, 及為majority number
 *
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int threshold = nums.length / 2;
        for (int x : nums) {
            int count = map.getOrDefault(x, 0) + 1;
            if (count > threshold)
                return x;
            map.put(x, count);
        }
        throw new IllegalArgumentException();
    }
}