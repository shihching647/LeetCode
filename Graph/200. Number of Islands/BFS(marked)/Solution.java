/**
 * BFS with marked (會TLE但不確定why)
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
                    bfs(grid, i, j, marked);
                    count++;
                }
            }
        }
        return count;
    }
    
    private void bfs(char[][] grid, int startI, int startJ, boolean[][] marked) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startI, startJ});
        while (!q.isEmpty()) {
            int[] next = q.poll();
            int i = next[0];
            int j = next[1];
            marked[i][j] = true;
            int[][] direct = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            for (int k = 0; k < direct.length; k++) {
                int y = i + direct[k][0];
                int x = j + direct[k][1];
                if (x >= 0 && x < grid[0].length && y >= 0 && y < grid.length && !marked[y][x] && grid[y][x] == '1') {
                    // marked[y][x] = true;
                    q.offer(new int[]{y, x});
                }
            }
        }
    }
}