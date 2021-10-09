/**
 * 當發現某一個cell是1的時候, 以他為起點往右往下DFS
 * 
 * 參考: https://www.youtube.com/watch?v=dCNPK13QCP8&ab_channel=CherryCoding%5BIIT-G%5D
 * Time complexity: O(m * n)
 * Space complexity: O(m * n)
 *
 */

class Solution {
    public int[][] findFarmland(int[][] land) {
        int m = land.length;
        int n = land[0].length;
        boolean[][] marked = new boolean[m][n];
        List<int[]> list = new LinkedList<>();
        
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (land[r][c] == 1 && !marked[r][c]) {
                    dfs(r, c, r, c, land, marked, list);
                }
            }
        }
        return list.toArray(new int[list.size()][4]);
    }
    
    private void dfs(int row, int col, int r, int c, int[][] land, boolean[][] marked, List<int[]> list) {
        int m = land.length; // r
        int n = land[0].length; // c
        marked[r][c] = true;
        
        // 4個條件代表到達終點
        if (c == n - 1 && r == m - 1) { // 到達最右下角的那格
            list.add(new int[] {row, col, r, c});
            return;
        } else if (c == n - 1 && r + 1 < m && land[r + 1][c] == 0) { // 最右邊(c == n - 1)且下方那格為0(land[r + 1][c] == 0)
            list.add(new int[] {row, col, r, c});
            return;
        } else if (r == m - 1 && c + 1 < n && land[r][c + 1] == 0) { // 最下面(r == m - 1)且右方那格為0(land[r][c + 1] == 0)
            list.add(new int[] {row, col, r, c});
            return;
        } else if (r + 1 < m && c + 1 < n && land[r][c + 1] == 0 && land[r + 1][c] == 0) { // 右邊跟下面都為0
            list.add(new int[] {row, col, r, c});
            return;
        }
        
        // 往下dfs
        if (r + 1 < m && !marked[r + 1][c] && land[r + 1][c] == 1)
            dfs(row, col, r + 1, c, land, marked, list);
        // 往右dfs
        if (c + 1 < n && !marked[r][c + 1] && land[r][c + 1] == 1)
            dfs(row, col, r, c + 1, land, marked, list);
    }
}