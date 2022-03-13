/**
 * Brute force
 * 
 * Time complexity: O(kN)
 * Space complexity: O(1)
 */

class Solution {

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int offset = k % n;
        for (int i = 0; i < offset; i++) {
            rotateByOne(nums);
        }
    }
    
    private void rotateByOne(int[] nums) {
        int pre = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[(i + 1) % nums.length];
            nums[(i + 1) % nums.length] = pre;
            pre = temp;
        }
    }
}