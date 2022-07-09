/**
 * DP: 兩次 DP iteration, 一次取得左邊上面的最小值, 一次取得右邊下面的最小值.
 * 
 * 參考: https://www.youtube.com/watch?v=YTnYte6U61w&ab_channel=LeetCode%E5%8A%9B%E6%89%A3
 * 
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 * 
 **/
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dest = new int[m][n];
        
        // init
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dest[i][j] = 10005; // 不能初始化成Integer.MAX_VALUE,因為有可能在比較大小時+1導致over flow, 所以初始化成超過矩陣最大元素10 ^ 4就可以
            }
        }
        
        // 1st pass: 左上->右下
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    dest[i][j] = 0;
                } else {
                    if (i > 0)
                        dest[i][j] = Math.min(dest[i][j], dest[i - 1][j] + 1); // 上面
                    if (j > 0)
                        dest[i][j] = Math.min(dest[i][j], dest[i][j - 1] + 1); // 左邊
                }
            }
        }
        
        // 2nd pass: 右下 -> 左上
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (mat[i][j] == 0) {
                    dest[i][j] = 0;
                } else {
                    if (i < m - 1)
                        dest[i][j] = Math.min(dest[i][j], dest[i + 1][j] + 1); // 下面
                    if (j < n - 1)
                        dest[i][j] = Math.min(dest[i][j], dest[i][j + 1] + 1); // 右邊
                }
            }
        }
        
        return dest;
    }
}