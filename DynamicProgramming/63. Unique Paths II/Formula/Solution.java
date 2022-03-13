/**
 * 回到問題的本質:
 * m * n的gird, 從左上角走到右下角共需 m + n - 2步, 其中有m - 1步往右, n - 1步往下
 * 所以共有C(m + n - 2, m - 1)種走法
 * 
 * Time complexity: O(m)
 * Space complexity: O(1)
 */

class Solution {
    public int uniquePaths(int m, int n) {
        int N = m + n - 2;
        int k = m - 1;
        long result = 1;
        for (int i = 1; i <= k; i++) {
            result = result * (N - k + i) / i;
        }
        return (int) result;
    }
}