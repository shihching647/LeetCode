/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

/**
 * 
 * 參考: https://www.youtube.com/watch?v=GgP75HAvrlY&ab_channel=BackToBackSWE
 * 
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 * 
 **/
class Solution {
    public int numTrees(int n) {
        int[] memo = new int[n + 1]; // number of unique BST with unique n numbers
        return numTrees(n, memo);
    }
    
    private int numTrees(int n, int[] memo) {
        if (memo[n] > 0)
            return memo[n];
        
        if (n == 0) {
            memo[n] = 1;
            return memo[n];
        }

        // root可以從1 ~ i, 每個root, 左邊有root - 1個元素, 右邊可以是n - root個元素, 兩個相乘
        // numTrees(4) = {1,2,3,4}的解 = {2,3,4,5}的解 = {3,4,5,6}的解
        for (int root = 1; root <= n; root++) {
            memo[n] += numTrees(root - 1, memo) * numTrees(n - root, memo); 
        }
        
        return memo[n];
    }
}