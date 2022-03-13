/**
 * Juggling Algorithm
 * 1. 把nums分成gcd(k % n, n)個set.
 * 2. 從index 0那個set開始, 將set裡面的元素向右移動k個位置.
 * 
 * 參考: https://www.youtube.com/watch?v=utE_1ppU5DY&ab_channel=CodeWhoop
 * Time complexity: O(N)
 * Space complexity: O(1)
 */

class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int offset = k % n;
        int gcd = gcd(offset, n);
        for (int i = 0; i < gcd; i++) {
            // 將set裡面的元素向右移動k個位置.
            int j = i;
            int temp = nums[j];
            while (true) {
                int nextPos = (n + j - offset) % n; // 往右移
                if (nextPos == i) 
                    break;
                nums[j] = nums[nextPos];
                j = nextPos;
            } 
            nums[j] = temp;
        }
    }
    
    // suppose a <= b
    private int gcd(int a, int b) {
        if (a == 0) return b;
        else return gcd(b % a, a);
    }
}