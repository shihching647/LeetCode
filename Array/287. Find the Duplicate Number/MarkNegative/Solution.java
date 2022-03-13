/**
 * 因為數字在[1, n]裡面且為正的, 所以遇到nums[i]時, 把nums[nums[i]]改成負的, 代表nums[i]出現過了
 * 所以nums[nums[i]] < 0的話, 代表nums[i]為duplicate.
 * 
 * Time complexity: O(N)
 * Space complexity: O(1)
 */
class Solution {
    public int findDuplicate(int[] nums) {
        int duplicate = -1;
        for (int i = 0; i < nums.length; i++) {
            int cur = Math.abs(nums[i]);
            if (nums[cur] < 0) {
                duplicate = cur;
                break;
            }
            nums[cur] = nums[cur] * -1;
        }
        // restore array
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.abs(nums[i]);
        }
        return duplicate;
    }
}