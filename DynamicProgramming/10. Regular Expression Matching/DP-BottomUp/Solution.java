/**
 * Recursion + 二維DP(Bottom-up) (參考:https://www.youtube.com/watch?v=KN22ZEpRTFY&ab_channel=%E5%82%85%E7%A0%81%E7%88%B7)
 * 先看第一個字元有沒有滿足
 * 檢查第二個字母是否為'*'(因為*前面一定是一個valid的字元(如:a,b,c...或.))
 * 若為* => 兩種情況都要explore下去, 1.要使用*前那個字元(字元符合) 2.不使用字元
 * 若不為* => 直接移到下一個檢查是否一樣
 * 
 * DP(i,j)定義為 : s[i:], p[j:] 是否match
 * Bottom up: 從最後往前填, 答案為s[0:], p[0:] = DP(0,0)
 *
 * 會重複使用的情況如: s = "abab" p = "a*a*"
 * 第一個"ab"會去match "a*a*", 第二個"ab"也會去match "a*a*"
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
        for (int i = s.length(); i >= 0; i--) {
            for (int j = p.length() - 1; j >= 0; j--) {
                boolean isFirstCharMatch = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
                if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                    table[i][j] = isFirstCharMatch && table[i + 1][j] || table[i][j + 2];
                } else {
                    table[i][j] = isFirstCharMatch && table[i + 1][j + 1];  
                }
            }
        }
        
        return table[0][0]; // 
    }
}