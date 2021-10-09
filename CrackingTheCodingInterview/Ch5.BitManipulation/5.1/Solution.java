/**
 * 
 * Time complexity: O(1)
 * Space complexity: O(1)
 *
 */
class Solution {

    public static int insertBitsRangeOfficial(int n, int m, int i, int j) {
        int leftPart = ~0 << (j + 1);
        int rightPart = (1 << i) - 1;
        int mask = leftPart | rightPart; // mask = i ~ j位置bit為0, 其他為1
        return n & mask | (m << i);
    }

    public static void main(String[] args) {
        int m = Integer.parseInt("10011", 2);
        int n = Integer.parseInt("11101100011", 2);
        System.out.println(Integer.toBinaryString(insertBitsRangeOfficial(n, m, 2, 6))); // 11101001111
    }
}