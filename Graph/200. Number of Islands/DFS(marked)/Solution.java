/**
 * DFS with marked
 * 
 * Time complexity: O(M * N)
 * Space complexity: O(M * N)
 *
 */
class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] marked = new boolean[n][m];
        
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!marked[i][j] && grid[i][j] == '1') {
                    dfs(grid, i, j, marked);
                    count++;
                }
            }
        }
        return count;
    }
    
    private void dfs(char[][] grid, int i, int j, boolean[][] marked) {
        marked[i][j] = true;
        int[] direct = {0, 1, 0, -1, 0};
        for (int k = 0; k < 4; k++) {
            int y = i + direct[k];
            int x = j + direct[k + 1];
            if (x >= 0 && x < grid[0].length && y >= 0 && y < grid.length && !marked[y][x] && grid[y][x] == '1') {
                dfs(grid, y, x, marked);
            }
        }
    }
}