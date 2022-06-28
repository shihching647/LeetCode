/**
 * Flip Bit to Win:
 * You have an integer and you can flip exactly one bit from a 0 to a 1. Write code to
 * find the length of the longest sequence of ls you could create.
 *
 * Brute force:
 * 檢查每一個bit是否為0, 若為0的話設成1, 檢查可得到的最長長度
 * 
 * Time Complexity: O(b^2)
 * Space Complexity: O(1)
 */
class Solution {

    private static int flipBitToWin(int num) {
        // 全部都是1直接回傳
        if (~num == 0)
            return Integer.SIZE;

        int max = 0;
        int mask = 1;
        for (int i = 0; i < Integer.SIZE; i++) {
            if ((num & mask) == 0) {
                max = Math.max(max, checkMaxLength(num | (1 << i)));
            }
            mask <<= 1;
        }
        return max;
    }

    private static int checkMaxLength(int num) {
        if (~num == 0)
            return Integer.SIZE;

        int max = 0;
        int cur = 0;
        int mask = 1;
        for (int i = 0; i < Integer.SIZE; i++) {
            if ((num & mask) == 0) {
                cur = 0;
            } else {
                cur++;
            }
            mask <<= 1;
            max = Math.max(max, cur);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(flipBitToWin(1775)); // 8
        System.out.println(flipBitToWin(-1)); // 32
        System.out.println(flipBitToWin(-2)); // 32
        System.out.println(flipBitToWin(3)); // 3
    }
}