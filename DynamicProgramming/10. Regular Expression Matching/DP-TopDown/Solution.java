/**
 * Recursion + 二維DP (參考:https://www.youtube.com/watch?v=HAA8mgxlov8&ab_channel=NeetCode)
 * 先看第一個字元有沒有滿足
 * 檢查第二個字母是否為'*'(因為*前面一定是一個valid的字元(如:a,b,c...或.))
 * 若為* => 兩種情況都要explore下去, 1.要使用*前那個字元(字元符合) 2.不使用字元
 * 若不為* => 直接移到下一個檢查是否一樣
 * 
 * DP(i,j)定義為 : s[i:], p[j:] 是否match
 * 
 * 會重複使用的情況如: s = "abab" p = "a*a*"
 * 第一個"ab"會去match "a*a*", 第二個"ab"也會去match "a*a*"
 * 
 * Time complexity: O(n * m)
 * Space complexity: O(n * m)
 */
class Solution {
    public boolean isMatch(String s, String p) {
        Boolean[][] memo = new Boolean[s.length() + 1][p.length() + 1];
        return isMatch(s, p, 0, 0, memo);
    }
    
    private boolean isMatch(String s, String p, int i, int j, Boolean[][] memo) {
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        if (j == p.length()) {
            memo[i][j] = (i == s.length());
            return memo[i][j];
        }
            
        boolean isFirstCharMatch = i != s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        boolean result = false;
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            // 1. 第一個字元要符合 -> 要用*前面的那一個字元
            // 2. 不用那個字元
            result = isFirstCharMatch && isMatch(s, p, i + 1, j, memo) || isMatch(s, p, i, j + 2, memo);
        } else {
            // 若第一個字元符合才需比對下一個字元
            result = isFirstCharMatch && isMatch(s, p, i + 1, j + 1, memo);
        }
        memo[i][j] = result;
        return result;
    }
}