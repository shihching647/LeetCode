/**
 * Brute force: 找每個index i的最長palindrome(index從n - 1開始, l從n - i開始), dp table可宣告成一維的
 * dp[i, j]定義為: S[i, j]是否為palindrome
 * (dp table填法請參考圖片)
 * 
 * Time complexity: O(N ^ 2)
 * Space complexity: O(N)
 *
 */

class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 1)
            return s;
        String ans = "";
        boolean[] table = new boolean[n];
        for (int i = n - 1; i >= 0; i--) {
            for (int l = n - i; l >= 1; l--) {
                int end = i + l - 1;
                // 長度為1, 2要獨立檢查
                table[end] = (l == 1 || l == 2 || table[end - 1]) && s.charAt(i) == s.charAt(end);
                if (table[end] && l > ans.length()) {
                    ans = s.substring(i, i + l);
                }
            }
        }
        return ans;
    }
}