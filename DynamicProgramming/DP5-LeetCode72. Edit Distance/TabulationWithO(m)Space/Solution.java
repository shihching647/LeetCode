/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

/**
 * Tabulation(Bottom up) dynamic programming
 * 參考: https://www.youtube.com/watch?v=MiqoA-yF-0M&ab_channel=BackToBackSWE
 * 每次填第i列時候只需要i - 1列的資訊, 故可以把table從O(n * m)簡化成O(m)
 *
 * Time Complexity: O(n * m)
 * Space Complexity: O(m)
 */

class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        
        int[] table = new int[m + 1];
        for (int j = 0; j < table.length; j++) {
            table[j] = j;
        }
        
        for (int i = 1; i <= n; i++) {
            int leftUp = table[0]; // 左上角
            table[0] = i; // 左邊
            for (int j = 1; j <= m; j++) {
                int up = table[j]; // 上面
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    table[j] = leftUp;
                } else {
                    table[j] = 1 + Math.min(table[j - 1], Math.min(leftUp, up));
                }
                leftUp = up; // 舊的上面是新的左上角
            }
        }
        return table[m];
    }
}