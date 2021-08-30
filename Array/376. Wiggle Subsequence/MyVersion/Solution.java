/**
 * 
 * Time complexity: O(n^2)
 * Space complexity: O(1)
 */

class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 1)
            return nums.length;
        
        int max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int len = 0;
            if (nums[i] == nums[i + 1]) {
                len = 1;
            } else {
                boolean pre = diff(nums[i], nums[i + 1]);
                len = 2;
                for (int j = i + 2; j < nums.length; j++) {
                    if (nums[j] != nums[j - 1] && pre == !diff(nums[j - 1], nums[j])) {
                        len++;
                        pre = diff(nums[j - 1], nums[j]);
                    }
                }
            }
            max = Math.max(len, max);
        }
        return max;
    }
    
    private boolean diff(int i, int j) {
        return i - j > 0;
    }
}