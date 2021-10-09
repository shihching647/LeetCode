/**
 * 由後往前Iteration, 並使用Map紀錄出現的數字.(看到有i < j < k 這種條件就馬上想到由後往前!!)
 *
 * Time complexity: O(N^3)
 * Space complexity: O(100) (nums[i]最大的值)
 *
 */
class Solution {
    public int countQuadruplets(int[] nums) {
        int n = nums.length;
        int[] map = new int[101]; // 因為nums[i] <= 100
        map[nums[n - 1]] = 1;
        int count = 0;
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                for (int k = j - 1; k >= 0; k--) {
                    if (nums[i] + nums[j] + nums[k] <= 100)
                        count += map[nums[i] + nums[j] + nums[k]];
                }
            }
            map[nums[i]] += 1;
        }
        return count;
    }
}