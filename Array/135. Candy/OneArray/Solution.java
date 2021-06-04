/**
 * One array: Two array一樣的邏輯, 只是只用一個array
 * 3次迴圈
 * 第1次: left -> right, 如果分數比左邊的大, 多拿一顆
 * 第2次: 直接算ans
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left2Right = new int[n];
        
        // left -> right, 如果分數比左邊的大, 多拿一顆
        int i = 0;
        left2Right[i++] = 1;
        while (i < n) {
            if (ratings[i] > ratings[i - 1]) {
                left2Right[i] = left2Right[i - 1] + 1; 
            } else {
                left2Right[i] = 1;
            }
            i++;
        }
        
        // right -> left, 不需要用新的array直接跟left2Right[i]取最大值, 並加到ans裡
        int ans = left2Right[n - 1];
        i = n - 2;
        while (i >= 0) {
            int count = 1;
            if (ratings[i] > ratings[i + 1]) {
                count = left2Right[i + 1] + 1;
                left2Right[i] = Math.max(count, left2Right[i]);
            }
            ans += left2Right[i];
            i--;
        }
        return ans;
    }
}