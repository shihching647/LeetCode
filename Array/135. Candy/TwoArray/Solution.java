/**
 * Two array:
 * 3次迴圈
 * 第1次: left -> right, 如果分數比左邊的大, 多拿一顆
 * 第2次: right -> left, 如果分數比右邊的大, 多拿一顆
 * 第3次: 該拿的為兩次中的最大值
 * Time complexity: O(n)
 * Space complexity: O(n)
 */


class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left2Right = new int[n];
        int[] right2Left = new int[n];
        
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
        
        // right -> left, 如果分數比右邊的大, 多拿一顆
        i = n - 1;
        right2Left[i--] = 1;
        while (i >= 0) {
            if (ratings[i] > ratings[i + 1]) {
                right2Left[i] = right2Left[i + 1] + 1; 
            } else {
                right2Left[i] = 1;
            }
            i--;
        }
        
        // 該拿的為left2Right[i], right2Left[i]最大值
        i = 0;
        int ans = 0;
        while (i < n) {
            ans += Math.max(left2Right[i], right2Left[i]);
            i++;
        }
        return ans;
    }
}