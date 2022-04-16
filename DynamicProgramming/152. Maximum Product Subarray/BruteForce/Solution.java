/**
 * Brute force:
 * 
 * Time complexity: O(N^2)
 * Space complexity: O(1)
 */
class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int product = nums[i];
            max = Math.max(max, product);
            for (int j = i + 1; j < nums.length; j++) {
                product *= nums[j];
                max = Math.max(max, product);
            }
        }
        return max;
    }
}