/**
 * Matrice multiplication representation: 
 * 4 matrices multiplication => (10 * 30) * (30 * 5) * (5 * 60) => [10, 30, 5, 60]
 * 
 * Bottom up DP:
 * 
 * 參考: https://www.youtube.com/watch?v=eTL-lqbBbEw&list=RDCMUCnxhETjJtTPs37hOZ7vQ88g&index=2&ab_channel=TECHDOSE
 * 
 * Time Complexity: O(N ^ 3)
 * Space Complexity: O(N ^ 2)
 * 
 **/
class Solution {
    public static int mcm(int[] matrices) {
        int n = matrices.length;
        int[][] table = new int[n][n];
        for (int size = 2; size < n; size++) { // sub problem with size 2 ~ n - 1 (matrices的length是n, 代表 n - 1個Matrix相乘, 所以共有2 ~ n - 1個的sub problem)
            for (int l = 1; l <= n - size; l++) { // left boundary (從1 ~ n - size, 因爲matrices[0]只代表第一個matrix的row, 不能切, 所以要從1開始)
                int r = l + size - 1;             // right boundary (有size, 有left boundary, r = l + size - 1)
                int min = Integer.MAX_VALUE;
                for (int k = l; k < r; k++) {    // 嘗試切在第k個位置(l ~ r - 1)
                    int temp = table[l][k] + table[k + 1][r] + matrices[l - 1] * matrices[k] * matrices[r];
                    min = Math.min(min, temp);
                }
                table[l][r] = min;
            }
        }
        return table[1][n - 1];
    }

    public static void main(String[] args) {
        int[] matrices = {30, 35, 15, 5, 10, 20, 25};
        System.out.println(mcm(matrices));
    }
}