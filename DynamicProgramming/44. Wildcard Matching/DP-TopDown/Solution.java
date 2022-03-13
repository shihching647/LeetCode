/**
 * Recursion + DP(Top Down) (參考LeetCode10. Regular Expression Matching)
 * 先看第一個字元有沒有滿足
 * 檢查第一個字母是否為'*'
 * 若為* => 兩種情況都要explore下去, 1.要使用* 2.不使用*
 * 若不為* => 直接移到下一個檢查是否一樣
 * 
 * DP(i,j)定義為 : s[i:], p[j:] 是否match
 * 
 * Time complexity: O(n * m)
 * Space complexity: O(n * m)
 */
class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        Boolean[][] memo = new Boolean[n + 1][m + 1];
        return isMatch(s, p, 0, 0, memo);
    }
    
    private boolean isMatch(String s, String p, int i, int j, Boolean[][] memo) {
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        boolean result = false;
        if (j == p.length()) {
            result = (i == s.length());
            memo[i][j] = result;
            return result;
        }
    
        boolean isFirstCharMatch = i != s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?');
        if (p.charAt(j) == '*') {
            result = (i != s.length() && isMatch(s, p, i + 1, j, memo)) || isMatch(s, p, i, j + 1, memo);
        } else {
            result = isFirstCharMatch && isMatch(s, p, i + 1, j + 1, memo);
        }
        memo[i][j] = result;
        return result;
    }
}