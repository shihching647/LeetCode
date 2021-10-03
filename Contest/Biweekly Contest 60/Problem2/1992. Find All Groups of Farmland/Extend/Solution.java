/**
 * 當發現某一個cell是1的時候, 以他起點往外extend, 找到大都是1的rectangle.
 * 因為題目有說： 任兩個框框不會相鄰, 所以可以直接往右找(找到右邊的界線), 再往下找(找到下面的界線)
 * 直接圍起來就是最大的rectangle了
 * 
 * Time complexity: O(m * n)
 * Space complexity: O(1)
 *
 */

class Solution {
    public int[][] findFarmland(int[][] land) {
        int m = land.length;
        int n = land[0].length;
        List<int[]> list = new LinkedList<>();
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (land[r][c] == 1) {
                    extend(r, c, land, list);
                }
            }
        }
        return list.toArray(new int[list.size()][4]);
    }
    
    private void extend(int row, int col, int[][] land, List<int[]> list) {
        int m = land.length;
        int n = land[0].length;
        
        // 往下找
        int r = row;
        while (r + 1 < m && land[r + 1][col] == 1) {
            r++;
        }
        
        // 往右找
        int c = col;
        while (c + 1 < n && land[row][c + 1] == 1) {
            c++;
        }
        list.add(new int[]{row, col, r, c});
        
        // 把已經visit過的cell標成0
        for (int i = row; i <= r; i++) {
            for (int j = col; j <= c; j++) {
                land[i][j] = 0;
            }
        }
        return;
    }
}