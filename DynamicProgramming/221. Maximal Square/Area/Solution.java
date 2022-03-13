/**
 * Brute Force + 面積法:
 * 嘗試每一個點當作起點O(m * n), 找到最大所有都是1的面積 O(Math.min(m, n)) => O(n^3)
 * 
 * 如何在O(Math.min(m, n))找到所有都是1的面積:
 * 先開一個dp[m + 1][n + 1] // 開m + 1, n + 1的原因是: 避免y為0, x為0時要特殊處理.
 * dp[y][x] = 紀錄從(0, 0)開始到(y - 1, x - 1)的數字和
 * 再由公式
 * area(x, x + len, y, y + len) = area(0, x + len, 0, y + len)
 *                              - area(0, x + len, 0, y - 1)
 *                              - area(0, x - 1, 0, y + len)
 *                              + area(0, x - 1, 0, y - 1)
 * 即可算出(可參考圖find_max) 
 *
 * 參考: https://www.youtube.com/watch?v=vkFUB--OYy0&ab_channel=HuaHua
 * Time complexity: O(N ^ 3)
 * Space complexity: O(N ^ 2)
 */
class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        // pre-compute dp
        int[][] dp = new int[m + 1][n + 1];
        for (int y = 1; y <= m; y++) {
            for (int x = 1; x <= n; x++) {
                dp[y][x] = dp[y - 1][x] 
                         + dp[y][x - 1] 
                         - dp[y - 1][x - 1] 
                         + matrix[y - 1][x - 1] - '0';
            }
        }
        
        // find max
        int ans = 0;
        for (int y = 1; y <= m; y++) {
            for (int x = 1; x <= n; x++) {
                for (int len = Math.min(m - y + 1, n - x + 1); len > 0; len--) { // 從最大面積開始找
                    int area = dp[y + len - 1][x + len - 1] 
                             - dp[y + len - 1][x - 1] 
                             - dp[y - 1][x + len - 1] 
                             + dp[y - 1][x - 1];
                    if (area == len * len) {
                        ans = Math.max(ans, area);
                        break;
                    }
                }
            }
        }
        return ans;
    }
}