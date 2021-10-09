/**
 * 使用DP. DP[t] = target為t的所有組合. (使用HashMap)
 * 
 * Time complexity: O(???)
 * Space complexity: O(???)
 *
 */
class Solution {
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int t = nums[0]; t <= target; t++) {
            int count = map.getOrDefault(t, 0);
            for (int i = 0; i < nums.length && nums[i] <= t; i++) {
                if (nums[i] == t) count++;
                count += map.getOrDefault(t - nums[i], 0);
            }
            map.put(t, count);
        }
        return map.getOrDefault(target, 0);
    }
}