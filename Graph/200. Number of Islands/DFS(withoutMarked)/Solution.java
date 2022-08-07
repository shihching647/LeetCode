/**
 * DFS without marked
 * 
 * Time complexity: O(M * N)
 * Space complexity: O(M * N)
 *
 */
class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    
    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0')
            return;
        grid[i][j] = '0'; // 修改grid '1' -> '0'
        dfs(grid, i + 1, j);
        dfs(grid, i - 1 , j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}