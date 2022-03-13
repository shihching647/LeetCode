/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

/**
 * 
 * 參考: https://www.youtube.com/watch?v=MiqoA-yF-0M&ab_channel=BackToBackSWE
 * 
 * Time Complexity: O(n * m)
 * Space Complexity: O(n * m)
 * 
 **/
class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        // init memo
        int[][] memo = new int[n + 1][m + 1];
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[i].length; j++) {
                memo[i][j] = -1;
            }
        }
        return minDistance(word1, word2, n, m, memo);
    }
    
    private int minDistance(String word1, String word2, int n, int m, int[][] memo) {
        if (memo[n][m] > 0)
            return memo[n][m];
        
        if (n == 0) // n == 0, 做m個insertion
            memo[n][m] = m;
        else if (m == 0) // m == 0, 做n個deletetion
            memo[n][m] = n;
        else if (word1.charAt(n - 1) == word2.charAt(m - 1)) {
            memo[n][m] = minDistance(word1, word2, n - 1, m - 1, memo);
        } else {
            // 不相等 -> 考慮1. replace(n-1, m-1) 2. delete(n - 1, m) 3.insert(n, m - 1)
            memo[n][m] = 1 + Math.min(minDistance(word1, word2, n - 1, m - 1, memo),
                                      Math.min(minDistance(word1, word2, n - 1, m, memo), minDistance(word1, word2, n, m - 1, memo)));
        }
        return memo[n][m];
    }
    
}