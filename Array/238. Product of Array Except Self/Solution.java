/**
 * Use left product and right proudct to calculate result
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int leftProduct = 1; // product of all left element before nums[i]
        for (int i = 0; i < n; i++) {
            result[i] = leftProduct;
            leftProduct *= nums[i];
        }
        
        int rightProduct = 1; // product of all right element before nums[i]
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= rightProduct;
            rightProduct *= nums[i];
        }
        return result;
    }
}