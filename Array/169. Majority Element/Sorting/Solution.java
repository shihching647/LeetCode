/**
 * 將nums排序, 中間那個數一定是majority(因為超過一半的數都是majority)
 *
 * Time complexity: O(NlogN)
 * Space complexity: O(1)
 */

class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}