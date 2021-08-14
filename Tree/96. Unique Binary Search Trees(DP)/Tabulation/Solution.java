/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

/**
 * Tabulation(Bottom up) dynamic programming
 * 參考: https://www.youtube.com/watch?v=GgP75HAvrlY&ab_channel=BackToBackSWE
 * 
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 */

class Solution {
    public int numTrees(int n) {
        int[] table = new int[n + 1]; // number of unique BST with unique n numbers 
        table[0] = 1; // 分支是null也是一種可能性
        table[1] = 1; // 一個元素只有一種可能性
        for (int i = 2; i <= n; i++) {
            int num = 0;
            // root可以從1 ~ i, 每個root, 左邊可以是table[root - 1], 右邊可以是table[i - root], 兩個相乘
            // 因為table[n]可以解釋成數字1 ~ n的解，也可以解釋成2 ~ n + 1的解, 只要是n個unique的number都行
            for (int root = 1; root <= i; root++) {
                num += table[root - 1] * table[i - root];
            }
            // 把i的解存到table[i]
            table[i] = num;
        }
        return table[n];
    }