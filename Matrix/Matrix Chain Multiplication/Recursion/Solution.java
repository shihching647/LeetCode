/**
 * Matrice multiplication representation: 
 * 4 matrices multiplication => (10 * 30) * (30 * 5) * (5 * 60) => [10, 30, 5, 60]
 * 
 * Recursion:
 * 
 * 參考: https://www.youtube.com/watch?v=zQrR8t7urEE&list=RDCMUCnxhETjJtTPs37hOZ7vQ88g&index=1&ab_channel=TECHDOSE
 * 
 * Time Complexity: O(???)
 * Space Complexity: O(???)
 * 
 **/
class Solution {

    public static int mcm(int[] matrices) {
        return mcm(matrices, 1, matrices.length - 1);
    }

    private static int mcm(int[] matrices, int l, int r) {
        if (l >= r)
            return 0;
        int min = Integer.MAX_VALUE;
        for (int i = l; i < r; i++) {
            int left = mcm(matrices, l, i);
            int right = mcm(matrices, i + 1, r);
            int current = matrices[l - 1] * matrices[i] * matrices[r];
            min = Math.min(min, left + right + current);
        }
        return min;
    }

    public static void main(String[] args) {
        int[] matrices = {10, 30, 5, 60};
        System.out.println(mcm(matrices));
    }
}