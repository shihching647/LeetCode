/**
 * Greedy: 
 * 從0開始, 使用left, right來表示從0可達的最遠範圍.
 * 每次都取可達到的最遠位置, 下一輪將left改成right + 1, right改成maxPosition
 * 
 * 參考: https://www.youtube.com/watch?v=dJ7sWiOoK7g&ab_channel=NeetCode
 * Time complexity: O(N)
 * Space complexity: O(1)
 */

class Solution {
    public int jump(int[] nums) {
        int step = 0; 
        int left = 0, right = 0; // left, right框出的區域為此層level可到達的區域
        while (right < nums.length - 1) {
            int maxPosition = 0;
            for (int i = left; i <= right; i++) {
                maxPosition = Math.max(maxPosition, i + nums[i]);
            }
            // 更新window, 進入下一個level
            left = right + 1;
            right = maxPosition;
            step++;
        }
        return step;
    }
}