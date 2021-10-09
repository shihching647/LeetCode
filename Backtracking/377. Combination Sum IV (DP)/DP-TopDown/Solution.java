/**
 * 使用DP. DP[t] = target為t的所有組合. (使用top-down的方法)
 * 當nums可能包含負數時只能用top-down的解法, 並且題目須給定可選擇入排列的個數(length), 否則會有無限種可能.
 * (如: nums = {1, -1}, target = {0} => {1,-1}, {1,-1,1,-1}, {1,-1,1,-1,1,-1})
 * 
 * Time complexity: O(???)
 * Space complexity: O(???)
 *
 */
class Solution {
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1; // 因為是top-down, 所以target == 0代表target - nums[i] == 0, 所以是1
        return combinationSum(nums, target, Integer.MAX_VALUE, dp);
    }
    
    // 當nums有可能包含負數的時候, 需要限定d的深度(可選擇入排列的個數)否則會有無限多個可能(呼叫combinationSum4()時需給定參數length)
    private int combinationSum(int[] nums, int target, int d, int[] dp) {
        if (d < 0) return 0;
        if (dp[target] != -1) {
            return dp[target];
        }
        int count = 0;
        for (int i = 0; i < nums.length && nums[i] <= target; i++) {
            // 當target - nums[i] == 0時, 會回傳1
            count += combinationSum(nums, target - nums[i], d - 1, dp);
        }
        dp[target] = count;
        return count;
    }
}