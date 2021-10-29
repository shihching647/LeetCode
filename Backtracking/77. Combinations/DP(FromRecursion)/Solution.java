/**
 * Recursion:  C(n, k) = C(n - 1, k - 1) + C(n - 1, k)
 * 要求C(n, k)的所有組合 = 
 * 1. 從n - 1裡面選k - 1, 再加上數字n
 * 2. 從n - 1裡面直接選k個數.
 * 
 * Time complexity: O(C(n, k))
 * Space complexity: O(C(n, k))
 *
 */
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>>[][] dp = new List[n + 1][k + 1]; // C(n, k)的解
        // k == 0的解
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = new ArrayList<>();
            dp[i][0].add(new ArrayList<>());
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i && j <= k; j++) {
                dp[i][j] = new ArrayList<>();
                // 2. 從n - 1裡面直接選k個數.
                if (i > j) { // 上一列只填到i - 1, 所以在這一列要加一個判斷i > j(在i裡面選j個)
                    dp[i][j].addAll(dp[i - 1][j]);
                }
                // 1. 從n - 1裡面選k - 1, 再加上數字n
                for (List<Integer> list : dp[i - 1][j - 1]) {
                    List<Integer> temp = new ArrayList<>(list);
                    temp.add(i);
                    dp[i][j].add(temp);
                }
            }
        }
        return dp[n][k];
    }
}