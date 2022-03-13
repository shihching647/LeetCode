/**
 * Recursion + DP(Bottom Up)的Space優化
 * 從最後一個position開始, 每次從0開始找, 找到小的index使得可到達position.
 * 下一輪此index當作position再從0開始找, 直到position為0即找到解答
 * 
 * 參考: https://leetcode.wang/leetCode-45-Jump-Game-II.html (解法2)
 * Time complexity: O(N ^ 2)
 * Space complexity: O(1)
 */

class Solution {
    public int jump(int[] nums) {
        int step = 0;
        int position = nums.length - 1;
        while (position > 0) {
            for (int i = 0; i < position; i++) {
                if (i + nums[i] >= position) {
                    position = i;
                    step++;
                    break; // 找到一個即可break, 因為只需要找到最小的index
                }
            }
        }
        return step;
    }
}