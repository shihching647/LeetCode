/**
 * 每一個x座標的儲水量 = min(左邊的max(包含自己), 右邊的max(包含自己)) - 自己
 *
 * Two pointer:
 * 由方法DP的圖可知道, 儲水量是由比較小的那個bar決定.
 * 所有keep兩個pointer left, right
 * 當 left比較小時, 如果height[left]比leftMax還小, 代表left位置這個水量不會被bound住, else 就會被bound住
 * right的同理
 *
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) return 0;
        int left = 0, right = n - 1;
        int leftMax = height[left], rightMax = height[right];
        int ans = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                // left比較小, 更新left
                if (height[left] >= leftMax) {
                    leftMax = height[left]; // 水不會被bound住所以不用加到ans, 並更新leftMax(之後bound別人)
                } else {
                    ans += leftMax - height[left]; // 水會被bound住, 加到ans
                }
                left++;
            } else {
                // right比較小, 更新right
                if (height[right] >= rightMax) {
                    rightMax = height[right]; 
                } else {
                    ans += rightMax - height[right];
                }
                right--;
            }
        }
        return ans;
    }
}
