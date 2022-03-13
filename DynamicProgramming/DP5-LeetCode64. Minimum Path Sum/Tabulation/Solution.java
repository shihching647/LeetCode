/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

/**
 * Tabulation(Bottom up) dynamic programming
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 */

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] table = new int[m][n];
        // 原點
        table[0][0] = grid[0][0];
        // 第一行
        for (int i = 1; i < m; i++){
            table[i][0] = grid[i][0] + table[i - 1][0];
        }
        // 第一列
        for (int j = 1; j < n; j++) {
            table[0][j] = grid[0][j] + table[0][j - 1];
        }
        // 其他
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                table[i][j] = grid[i][j] + Math.min(table[i - 1][j], table[i][j - 1]);
            }
        }
        return table[m - 1][n - 1];
    }
}