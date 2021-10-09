/**
 * nums[a] + nums[b] + nums[c] = nums[d] -> nums[a] + nums[b] = nums[d] - nums[c]
 * 由後往前Iteration, 固定b
 * 1. map存nums[d] - nums[c], 固定b, 往前找a
 * 2. 更新map, 把此固定b的與index大於b的組合家到map裡
 * 3. b--;
 * 
 * Time complexity: O(N^2)
 * Space complexity: O(100) (nums[i]最大的值)
 *
 */
class Solution {
    public int countQuadruplets(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(nums[n - 1] - nums[n - 2], 1);
        int count = 0;
        for (int i = n - 3; i >= 0; i--) {
            // 以nums[i]為界, 往前找 nums[j] + nums[i]的和在map裡面的
            for (int j = i - 1; j >= 0; j--) {
                count += map.getOrDefault(nums[j] + nums[i], 0);
            }
            
            // 加入nums[i]與i + 1 ~ n - 1的新的組合到map裡面
            for (int j = n - 1; j > i; j--) {
                int key = nums[j] - nums[i]; // j是最大的, 所以是nums[j] - nums[i]
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            
        }
        return count;
    }
}