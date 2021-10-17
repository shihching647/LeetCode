/**
 * 從最大的元素開始, 將每個元素嘗試分在不同的subset中.
 * 
 * 參考: https://www.youtube.com/watch?v=8XEcEYsG6Ck&ab_channel=%E5%82%85%E7%A0%81%E7%88%B7
 * Time complexity: O(K * 2 ^ N)
 * Space complexity: O(N)
 *
 */
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums) 
            sum += num;
        if (sum % k != 0) 
            return false; // sum不能整除k, 代表各個subset sum的target不為整數, return false
        int target = sum / k;
        int beginIndex = nums.length - 1; // 從最大的元素開始往前找, 這樣才不會TLE
        // 若nums[i]本身就為target, 直接自己成一組
        while (beginIndex >= 0 && nums[beginIndex] == target) {
            beginIndex--;
            k--;
        }
        int[] groups = new int[k];
        return helper(nums, groups, target, beginIndex);
    }
    
    // 將每個元素嘗試放入不同的group中
    private boolean helper(int[] nums, int[] groups, int target, int index) {
        if (index < 0) {
            return true; // index < 0代表所有元素用完, 代表找到解了
        }
        int num = nums[index];
        for (int j = 0; j < groups.length; j++) {
            if (target - groups[j] >= num) {
                groups[j] += num;
                if (helper(nums, groups, target, index - 1)) {
                    return true;
                }
                groups[j] -= num;
            }
        }
        return false;
    }
}