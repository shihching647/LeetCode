/**
 * 每個element都兩兩去嘗試裝水, 找出最大可裝的容量
 * Time complexity: O(n^2)
 * Space complexity: O(1)
 */
class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int n = height.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int volumn = Math.min(height[i], height[j]) * (j - i);
                max = Math.max(max, volumn);
            }
        }
        return max;
    }
}