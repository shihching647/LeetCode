/**
 * 找到s與reverse的longest common substring
 * dp[i, j] 定義為: s的index i, reverse的index j之間longset common substring的長度
 * LCS參考: https://www.youtube.com/watch?v=BysNXJHzCEs&ab_channel=TusharRoy-CodingMadeSimple
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
        String reverse = new StringBuilder(s).reverse().toString();
        int[][] table = new int[n][n];
        int pos = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (s.charAt(i) == reverse.charAt(j)) {
                    if (i == 0 || j == 0) {
                        table[i][j] = 1;
                    } else {
                        table[i][j] = table[i - 1][j - 1] + 1;
                    }
                }
                if (table[i][j] > max) {
                    // 找到的不一定是palindrome, 需再額外檢查reverse的index j對應的s index(beforeReverseIndex)
                    int beforeReverseIndex = n - j - 1;
                    if (beforeReverseIndex + table[i][j] - 1 == i) { // 檢查beforeReverseIndex + 長度 - 1是否等於i, 等於才是palindrome
                        pos = i;
                        max = table[i][j];
                    }
                }
            }
        }
        return s.substring(pos + 1 - max, pos + 1);
    }
}