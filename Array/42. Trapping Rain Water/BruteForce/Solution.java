/**
 * 每一個x座標的儲水量 = min(左邊的max(包含自己), 右邊的max(包含自己)) - 自己
 *
 * Time complexity: O(n^2)
 * Space complexity: O(1)
 */
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int leftMax = 0, rightMax = 0;
            for (int j = i; j >= 0; j--) {
                leftMax = Math.max(leftMax, height[j]);
            }
            for (int j = i; j < n; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }
            int amount = Math.min(leftMax, rightMax) - height[i];
            ans += amount;
        }
        return ans;
    }
}
