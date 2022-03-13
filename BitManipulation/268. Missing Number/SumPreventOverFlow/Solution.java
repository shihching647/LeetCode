/**
 * 先計算1~n的sum再扣掉nums數字和
 *
 * Time complexity: O(n)
 * Space complexity: O(1)
 *
 */

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += i + 1;
            sum -= nums[i];
        }
        return sum;
    }
}