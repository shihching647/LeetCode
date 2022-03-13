/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

/**
 * 
 * 
 * Time Complexity: O(n * m)
 * Space Complexity: O(n * m)
 * 
 **/
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] memo = new int[m][n];
        // init table
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }
        return minPathSum(grid, m - 1, n - 1, memo);
    }
    
    private int minPathSum(int[][] grid, int x, int y, int[][] memo) {
        // look up memo
        if (memo[x][y] >= 0)
            return memo[x][y];
        
        if (x == 0 && y == 0) {
            memo[x][y] = grid[x][y];
        } else if (x == 0) {
            memo[x][y] = grid[x][y] + minPathSum(grid, x, y - 1, memo);
        } else if (y == 0) {
            memo[x][y] = grid[x][y] + minPathSum(grid, x - 1, y, memo);
        } else {
            memo[x][y] = grid[x][y] + Math.min(minPathSum(grid, x - 1, y, memo), minPathSum(grid, x, y - 1, memo));
        }
        return memo[x][y];
    }
}