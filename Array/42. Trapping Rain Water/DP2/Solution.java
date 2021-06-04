/**
 * 每一個x座標的儲水量 = min(左邊的max(包含自己), 右邊的max(包含自己)) - 自己
 * Dynamic Programming:
 * 使用stack儲存index, 參考手繪的圖, 一輩子想不到
 *
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) return 0;
        int ans = 0, current = 0;
        Stack<Integer> stack = new Stack<>(); // 用來存index
        
        while (current < n) {
            // 當height[current] > height[stack.peek()], 代表前面的已經被bound住
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) { 
                int top = stack.pop();
                if (stack.isEmpty()) // 如果stack為空, 代表前面沒有bar可以bound住, 直接break
                    break;
                int distance = current - stack.peek() - 1; // 與另一個bound bar的距離
                int boundHeight = Math.min(height[current], height[stack.peek()]) - height[top]; // 計算current bar的水位
                ans += distance * boundHeight; // 見手繪圖
            }
            stack.push(current++);
        }
        return ans;
    }
}
