/**
 * Matrice multiplication representation: 
 * 4 matrices multiplication => (10 * 30) * (30 * 5) * (5 * 60) => [10, 30, 5, 60]
 * 
 * Top down DP:
 * 
 * 參考: https://www.youtube.com/watch?v=nrLREBkv0Nc&list=RDCMUCnxhETjJtTPs37hOZ7vQ88g&index=3&ab_channel=TECHDOSE
 * 
 * Time Complexity: O(N ^ 3)
 * Space Complexity: O(N ^ 2)
 * 
 **/

import java.util.Arrays;

class Solution {

    public static int mcm(int[] matrices) {
        int n = matrices.length;
        int[][] memo = new int[n][n];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return mcm(matrices, 1, matrices.length - 1, memo);
    }

    private static int mcm(int[] matrices, int l, int r, int[][] memo) {
        if (l >= r)
            return 0;
        if (memo[l][r] != -1)
            return memo[l][r];
        int min = Integer.MAX_VALUE;
        for (int i = l; i < r; i++) {
            int left = mcm(matrices, l, i, memo);
            int right = mcm(matrices, i + 1, r, memo);
            int current = matrices[l - 1] * matrices[i] * matrices[r];
            min = Math.min(min, left + right + current);
        }
        memo[l][r] = min;
        return min;
    }

    public static void main(String[] args) {
        int[] matrices = {30, 35, 15, 5, 10, 20, 25};
        System.out.println(mcm(matrices));
    }
}