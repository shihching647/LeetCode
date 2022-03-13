/**
 * Use a auxiliary array
 * 
 * Time complexity: O(N)
 * Space complexity: O(N)
 */

class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] aux = nums.clone();
        int offset = k % n;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = aux[(i + n - offset) % n];
        }
    }
}