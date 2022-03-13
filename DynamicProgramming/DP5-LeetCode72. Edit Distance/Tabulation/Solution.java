/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

/**
 * Tabulation(Bottom up) dynamic programming
 * 參考: https://www.youtube.com/watch?v=MiqoA-yF-0M&ab_channel=BackToBackSWE
 * Time Complexity: O(n * m)
 * Space Complexity: O(n * m)
 */

class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        // init table
        int[][] table = new int[n + 1][m + 1];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (i == 0)  // i == 0, 做j個insertion
                    table[i][j] = j;
                else if (j == 0) // j == 0, 做i個deletetion
                    table[i][j] = i;
                else if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    table[i][j] = table[i - 1][j - 1];
                else // 不相等 -> 考慮1. replace(i-1, j-1) 2. delete(i - 1, j) 3.insert(i, j - 1)
                    table[i][j] = 1 + Math.min(table[i - 1][j], Math.min(table[i][j - 1], table[i - 1][j - 1]));
            }
        }
        return table[n][m];
    }
}