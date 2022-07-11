/**
 * 先把nums排序, For each nums[i], 
 * transfer 3Sum question to nums[j] + nums[k] = -nums[i] (Two Sum Problem) 
 * 
 * Time complexity: O(n^2)
 * Space complexity: O(1)
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int target = -nums[i];
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            if (target < 0) break; 
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                if (nums[j] + nums[k] > target) k--;
                else if (nums[j] + nums[k] < target) j++;
                else {
                    result.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                    while (j < nums.length && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    while (k > j && nums[k] == nums[k + 1]) {
                        k--;
                    }
                }
            }
        }
        return result;
    }
}