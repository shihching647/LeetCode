/**
 * ^(XOR) operator : 互斥operator
 * 自己 ^ 自己 = 0
 * 自己 ^ 0 = 自己
 *
 * Time complexity: O(n)
 * Space complexity: O(1)
 *
 */

class Solution {
    public int missingNumber(int[] nums) {
        int result = nums.length;
        for (int i = 0; i < nums.length; i++) {
            result = result ^ i ^ nums[i];
        }
        return result;
    }
}