/**
 * Greedy approach:
 * 直接計算peak max 跟 peak min的數量就是答案了
 * 
 * 參考:https://www.youtube.com/watch?v=xtDu3jm5WsI&t=330s&ab_channel=alGOds&t=5m30s
 * Time complexity: O(n^2)
 * Space complexity: O(n) 
 */

class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        
        int preDif = nums[1] - nums[0];
        int count = preDif == 0 ? 1 : 2;
        for (int i = 2; i < nums.length; i++) {
            int dif = nums[i] - nums[i - 1];
            if ((preDif <= 0 && dif > 0) || (preDif >= 0 && dif < 0)) { // 發生peak值
                count++;
                preDif = dif;
            }
        }
        return count;
    }
}