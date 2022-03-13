/**
 * Brute force: 找每個index i的最長palindrome(l從1開始, index從0開始)
 * dp[i, j]定義為: S[i, j]是否為palindrome
 * (dp table填法請參考圖片)
 * 
 * Time complexity: O(N ^ 2)
 * Space complexity: O(N ^ 2)
 *
 */

class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 1)
            return s;
        String ans = "";
        boolean[][] table = new boolean[n][n];
        for (int l = 1; l <= n; l++) {
            for (int i = 0; i + l - 1< n; i++) {
                int end = i + l - 1;
                // 長度為1, 2要獨立檢查
                table[i][end] = (l == 1 || l == 2 || table[i + 1][end - 1]) && s.charAt(i) == s.charAt(end);
                if (table[i][end] && l > ans.length()) {
                    ans = s.substring(i, end + 1);
                }
            }
        }
        return ans;
    }
}