/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

/**
 * 
 * 參考: https://www.youtube.com/watch?v=ASoaQq66foQ&ab_channel=BackToBackSWE
 * 
 * Time Complexity: O(n * m)
 * Space Complexity: O(n * m)
 * 
 **/
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        // memo[n][m]存的是text1長度為n, text2長度為m時的LCS解
        int[][] memo = new int[n + 1][m + 1];
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[i].length; j++) {
                memo[i][j] = -1;
            }
        }
        return lengthLCS(text1, text2, n, m, memo);
    }
    
    private int lengthLCS(String text1, String text2, int n, int m, int[][] memo) {
        // look up memo
        if (memo[n][m] >= 0)
            return memo[n][m];
        
        if (n == 0 || m == 0) // 其中一個長度為0, return 0
            memo[n][m] = 0;
        else if (text1.charAt(n - 1) == text2.charAt(m - 1)) // 比較最後一個字元, 相等的話, 再遞迴往前比較
            memo[n][m] = 1 + lengthLCS(text1, text2, n - 1, m - 1, memo);
        else // 不相等, 再分別往下遞迴
            memo[n][m] = Math.max(lengthLCS(text1, text2, n - 1, m, memo),
                                  lengthLCS(text1, text2, n, m - 1, memo));
        return memo[n][m];
    }
}