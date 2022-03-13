/**
 * Recursion + DP(Bottom up) (參考LeetCode10. Regular Expression Matching)
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
        boolean[][] table = new boolean[n + 1][m + 1];
        table[n][m] = true;
        for (int i = n; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                boolean isFirstCharMatch = i != s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?');
                if (p.charAt(j) == '*') {
                    table[i][j] = (i != s.length() && table[i + 1][j]) || table[i][j + 1];
                } else {
                    table[i][j] = isFirstCharMatch && table[i + 1][j + 1];
                }
            }
        }
        return table[0][0];
    }
}