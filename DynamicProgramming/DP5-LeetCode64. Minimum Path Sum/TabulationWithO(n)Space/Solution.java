/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

/**
 * Tabulation(Bottom up) dynamic programming
 * 每次填第i列時候只需要i - 1列的資訊, 故可以把table從O(m * n)簡化成O(n)
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(n)
 */

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[] table = new int[n];
        table[0] = grid[0][0];
        for (int j = 1; j < n; j++) {
            table[j] = table[j - 1] + grid[0][j];
        }
        
        for (int i = 1; i < m; i++) {
            table[0] += grid[i][0]; 
            for (int j = 1; j < n; j++) {
                table[j] = grid[i][j] + Math.min(table[j - 1], table[j]);
            }
        }
        return table[n - 1];
    }
}