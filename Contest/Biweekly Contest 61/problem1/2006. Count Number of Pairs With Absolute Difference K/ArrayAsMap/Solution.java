/**
 * 使用array紀錄出現目前到現在各個數字出現的頻率(因為 1 <= nums[i] <= 100)
 * 
 * Time complexity: O(N)
 * Space complexity: O(R) (R個不同的數字)
 *
 */
class Solution {
    public int countKDifference(int[] nums, int k) {
        int[] map = new int[101];
        int count = 0;
        for (int num : nums) {
            count += (num + k <= 100 ? map[num + k] : 0) + (num - k > 0 ? map[num - k] : 0);
            map[num] += 1;
        }
        return count;
    }
}