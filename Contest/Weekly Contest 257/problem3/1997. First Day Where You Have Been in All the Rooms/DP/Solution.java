/**
 * DP: DP關係推導請看圖片
 *
 * Time complexity: O(N)
 * Space complexity: O(N)
 */

class Solution {
    
    private static final int MOD = 1000000007;
    
    public int firstDayBeenInAllRooms(int[] nextVisit) {
        int n = nextVisit.length;
        long[] dp = new long[n];
        for (int i = 1; i < n; i++) {
            // 因為2 * dp[i - 1] - dp[nextVisit[i - 1]]可能會是負的, 所以要再加一個MOD
            dp[i] = (2 + 2 * dp[i - 1] - dp[nextVisit[i - 1]] + MOD) % MOD;
        }
        return (int) dp[n - 1];
    }
}