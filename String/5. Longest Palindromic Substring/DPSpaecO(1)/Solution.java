/**
 * 找到s與reverse的longest common substring: spaec優化
 * dp[i, j] 定義為: s的index i, reverse的index j之間longset common substring的長度
 * LCS參考: https://www.youtube.com/watch?v=BysNXJHzCEs&ab_channel=TusharRoy-CodingMadeSimple
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
        String reverse = new StringBuilder(s).reverse().toString();
        int[] table = new int[n];
        int pos = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) { // 這邊從n - 1開始, 因為每次都用到左上角那一格. 所以從n - 1開始, 每次都用前一格(j - 1)就等於2D的左上角那一個 
                if (s.charAt(i) == reverse.charAt(j)) {
                    if (i == 0 || j == 0) {
                        table[j] = 1;
                    } else {
                        table[j] = table[j - 1] + 1;
                    }
                } else {
                    table[j] = 0; 
                }
                if (table[j] > max) {
                    int beforeReverseIndex = n - j - 1;
                    if (beforeReverseIndex + table[j] - 1 == i) {
                        pos = i;
                        max = table[j];
                    }
                }
            }
        }
        return s.substring(pos + 1 - max, pos + 1);
    }
}