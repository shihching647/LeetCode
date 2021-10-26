/**
 * DP(Bottom up):
 * 
 *        k              l - k
 * S1 [   x1    |         x2         ]
 *    i         i + k                i + l - 1
 * 
 * here we have two possibilities:
 *      
 * S2 [   y1    |         y2         ]
 *    j         j + k                j + l - 1
 *    
 * or 
 * 
 * S2 [       y1        |     y2     ]
 *    j                 j + l - k    j + l - 1 
 * 
 * 參考: https://leetcode.com/problems/scramble-string/discuss/29396/Simple-iterative-DP-Java-solution-with-explanation
 * 
 * Time Complexity: O(N ^ 3) (雖然是４個for loop, 但目的只是填N^3的table, 所以時間複雜度依然是N^3(第四個for loop會break))
 * Space Complexity: O(N ^ 3)
 * 
 **/
class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.length() == 1) {
            return s1.equals(s2);
        }
        if (s1.equals(s2)) {
            return true;
        }
        int n = s1.length();
        boolean[][][] dp = new boolean[n + 1][n][n]; // dp = 長度為l的字串, s1從i開始和s2從j開始, 是否為scramble
        
        for (int l = 1; l <= n; l++) { // 長度l從1 ~ n
            for (int i = 0; i <= n - l; i++) { // s1的開始位置i(0 ~ n-l原因是: l至少是1, 當l是1時, i <= n - 1)
                for (int j = 0; j <= n - l; j++) { // s2的開始位置j
                    if (l == 1) {
                        dp[l][i][j] = (s1.charAt(i) == s2.charAt(j));
                    } else {
                        // 從位置1 ~ l-1 (長度l共有l-1個位置可以切)嘗試切看看
                        for (int k = 1; k < l; k++) {
                            boolean result = dp[k][i][j] && dp[l - k][i + k][j + k] || dp[k][i][j + l - k] && dp[l - k][i + k][j];
                            dp[l][i][j] = result;
                            if (result) // 確認是scramble後就可以break
                                break;
                        }
                    }
                }
            }
        }
        
        return dp[n][0][0];
    }
}