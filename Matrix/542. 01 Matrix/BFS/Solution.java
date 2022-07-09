/**
 * Multi source BFS, 從每個0的位置開始找到所有0最短的距離
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
        Queue<int[]> q = new LinkedList<>();
        
        // init
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0)  {
                    q.offer(new int[]{i, j});
                    dest[i][j] = 0;
                } else {
                    dest[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        // multi-source BFS
        int[][] directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!q.isEmpty()) {
            int[] pos = q.poll();
            for (int i = 0; i < 4; i++) {
                int newC = pos[0] + directions[i][0];
                int newR = pos[1] + directions[i][1];
                if (newC >= 0 && newC < m && newR >= 0 && newR < n) {
                    if (dest[newC][newR] > dest[pos[0]][pos[1]] + 1) {
                        dest[newC][newR] = dest[pos[0]][pos[1]] + 1;
                        q.offer(new int[]{newC, newR});
                    }
                }
            }
        }
        
        return dest;
    }
}