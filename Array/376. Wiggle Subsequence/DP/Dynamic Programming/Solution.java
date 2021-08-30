/**
 * DP1
 * Time complexity: O(n^2)
 * Space complexity: O(n) 
 */

class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        
        int[] up = new int[nums.length]; // up[i]為到i為止(不包含i), 最長的wiggle sequence且最後為上升
        int[] down = new int[nums.length]; // down[i]為到i為止(不包含i), 最長的wiggle sequence且最後為下降
        
        // 每次將一個數字加入sequence中, 需要update之前所有的down和up
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) { // 為上升時
                    up[i] = Math.max(up[i], down[j] + 1); // 更新上升[i](需藉由下降[j])
                } else if (nums[i] < nums[j]) {
                    down[i] = Math.max(down[i], up[j] + 1);// 更新下降[i](需藉由上升[j])
                }
            }
        }
        
        return 1 + Math.max(down[nums.length - 1], up[nums.length - 1]); // 回傳要記得+1 (加上i自己)
    }
}