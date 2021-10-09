/**
 * 題意: 任何一個character A只有找到另一個character B, 使得B的attak跟defend都大於A, 此character A就是weak character.
 * Brute Force:
 *
 * Time complexity: O(N^2)
 * Space complexity: O(1)
 */
class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        int n = properties.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int[] c1 = properties[i];
            for (int j = 0; j < n; j++) {
                int[] c2 = properties[j];
                if (c1[0] < c2[0] && c1[1] < c2[1]) {
                    count++;
                    break; // 找到一個就可以break
                }
            }
        }
        return count;
    }
}