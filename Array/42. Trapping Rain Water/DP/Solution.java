/**
 * 每一個x座標的儲水量 = min(左邊的max(包含自己), 右邊的max(包含自己)) - 自己
 * Dynamic Programming:
 * 先iterate一遍, 找出leftMax(到i時左邊最大值), rightMax(到i時右邊最大值)
 * 再針對每一個height[i]求出該座標的儲水量
 *
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) return 0;
        
        // left max, right max
        ArrayList<Integer> leftMax = new ArrayList<>(n);
        ArrayList<Integer> rightMax = new ArrayList<>(n);
        leftMax.add(height[0]);
        rightMax.add(0, height[n - 1]);
        for (int i = 1; i < n; i++) {
            leftMax.add(Math.max(leftMax.get(i - 1), height[i]));
            rightMax.add(0, Math.max(rightMax.get(0), height[n - i - 1]));
        }
        
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.min(leftMax.get(i), rightMax.get(i)) - height[i];
        }
        return ans;
    }
}
