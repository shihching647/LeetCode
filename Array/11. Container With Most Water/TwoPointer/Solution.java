/**
 * Two pointer: start, end
 * 從兩邊往中間夾, 移動高度小的那一邊, 
 * 每次移動時, 只有當新的height大於等於舊的height最大值才重算
 * (因為當區間變小, 高必須變大才有可能是最大值)
 * 
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int start = 0, end = n - 1;
        // int maxStart = height[start], maxEnd = height[end];
        int max = 0;
        while (start < end) {
            // if (height[start] >= maxStart || height[end] >= maxEnd) {
            //     int volumn = Math.min(height[start], height[end]) * (end - start);
            //     if (volumn > max) {
            //         max = volumn;
            //         maxStart = height[start];
            //         maxEnd = height[end];
            //     }
            // }
            // 其實可以不必檢查, 直接每次都算
            int volumn = Math.min(height[start], height[end]) * (end - start);  
            max = Math.max(max, volumn);
            if (height[start] < height[end]) start++;
            else end--;
        }
        return max;
    }
}