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
        int sum = n * (n + 1) / 2;
        for (int num : nums) {
            sum -= num;
        }
        return sum;
    }
}