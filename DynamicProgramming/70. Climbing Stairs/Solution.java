/**
 * DP完成Fibonacci
 *
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

class Solution {
    public int climbStairs(int n) {
        if (n == 1)
            return 1;
        int pre1 = 1, pre2 = 2;
        for (int i = 2; i < n; i++) {
            int temp = pre2 + pre1;
            pre1 = pre2;
            pre2 = temp;
        }
        return pre2;
    }
}