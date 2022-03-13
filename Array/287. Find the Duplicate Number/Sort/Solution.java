/**
 * 先排序再找重複
 * 
 * Time complexity: O(NlogN)
 * Space complexity: O(logN) (quick sort for primitive type)
 */
class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1])
                return nums[i];
        }
        throw new IllegalArgumentException("");
    }
}