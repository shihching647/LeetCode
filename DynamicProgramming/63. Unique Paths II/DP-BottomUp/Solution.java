/**
 * DP(Bottom Up)
 * DP(i, j)定義為 : 從(0, 0)出發到達(i, j)共有幾種走法
 * 
 * Time complexity: O(m * n)
 * Space complexity: O(m *　ｎ)
 */

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        // special case(起點or終點有障礙物)
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1)
            return 0;
        
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] != 1) {
                    if (i == 0 && j == 0)  {
                        dp[i][j] = 1;
                    } else if (i == 0 && obstacleGrid[i][j - 1] != 1) { // 左邊那格有障礙, 只算上面那格的走法
                        dp[i][j] = dp[i][j - 1];
                    } else if (j == 0 && obstacleGrid[i - 1][j] != 1) { // 上面那格有障礙, 只算左邊的走法
                        dp[i][j] = dp[i - 1][j];
                    } else if (i != 0 && j != 0) { // 左邊和上面都沒有障礙, 左邊和上面的走法相加
                        dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                    }
                } else { // 該格有障礙, dp[i][j] = 0
                    dp[i][j] = 0;
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}