/**
 * Juggling Algorithm變形: 不需要將set分成gcd(k % n, n)個, 直接記錄目前動過幾個element.
 * 1. 把nums分成gcd(k % n, n)個set. --> 當每個set的元素都移動過時 == 總共移動了n的element
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
        int movedCount = 0;
        int i = 0;
        while (movedCount < n) {
            int j = i;
            int temp = nums[j];
            while (true) {
                int nextPos = (n + j - offset) % n; // 往右移
                if (nextPos == i) 
                    break;
                nums[j] = nums[nextPos];
                j = nextPos;
                movedCount++;
            } 
            nums[j] = temp;
            movedCount++;
            i++;
        }
    }
}