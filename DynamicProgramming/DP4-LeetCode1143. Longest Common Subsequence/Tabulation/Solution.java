/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

/**
 * Tabulation(Bottom up) dynamic programming
 * 參考: https://www.youtube.com/watch?v=ASoaQq66foQ&ab_channel=BackToBackSWE
 * Time Complexity: O(n * m)
 * Space Complexity: O(n * m)
 */

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        // memo[n][m]存的是text1長度為n, text2長度為m時的LCS解
        int[][] table = new int[n + 1][m + 1];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (i == 0 || j == 0) 
                    table[i][j] = 0;
                else if (text1.charAt(i - 1) == text2.charAt(j - 1))
                    table[i][j] = 1 + table[i - 1][j - 1];
                else
                    table[i][j] = Math.max(table[i][j - 1], table[i - 1][j]);
            }
        }
        return table[n][m];
    }
}