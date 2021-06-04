/**
 * Slope: 不知道怎麼解釋, 請看leetCode詳解
 * Time complexity: O(n)
 * Space complexity: O(1)
 */


class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if (n <= 1) return n;
        
        int ans = 0;
        int up = 0, down = 0;
        int oldSlope = 0, newSlope;
        
        for (int i = 1; i < n; i++) {
            // calculate new slope
            if (ratings[i] > ratings[i - 1]) newSlope = 1;
            else if (ratings[i] < ratings[i - 1]) newSlope = -1;
            else newSlope = 0;
            
            // check vally point
            if ((oldSlope < 0 && newSlope >= 0) || (oldSlope > 0 && newSlope == 0)) {
                ans += count(up) + count(down) + Math.max(up, down); // 這邊Math.max()不用加一, 算在下一輪
                // reset up, down
                up = 0;
                down = 0;
            }
            
            if (newSlope > 0) up++;
            else if (newSlope < 0) down++;
            else ans++;
            
            oldSlope = newSlope;
        }
        
        ans += count(up) + count(down) + Math.max(up, down) + 1; // 這邊要加一, 因為沒有下一輪
        return ans;
    }
    
    private int count(int n) {
        return n * (n + 1) / 2;
    }
}