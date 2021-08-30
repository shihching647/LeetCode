/**
 * 任何一個ugly number都是前面的ugly number乘上2或3或5
 * 參考: https://www.geeksforgeeks.org/ugly-numbers/ 的法二 
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

class Solution {
    public int nthUglyNumber(int n) {
        int[] table = new int[n];
        int i2 = 0, i3 = 0, i5 = 0;
        int next2 = 2, next3 = 3, next5 = 5;
        table[0] = 1;
        
        for (int i = 1; i < n; i++) {
            int next = Math.min(next2, Math.min(next3, next5));
            table[i] = next;
            if (next == next2) {
                i2++;
                next2 = table[i2] * 2;
            }
            if (next == next3) {
                i3++;
                next3 = table[i3] * 3;
            }
            if (next == next5) {
                i5++;
                next5 = table[i5] * 5;
            }
        }
        
        return table[n - 1];
    }
}