/**
 * Counting sort
 * 
 * Time complexity: O(N)
 * Space complexity: O(1)
 */

class Solution {
    public void sortColors(int[] nums) {
        int count0 = 0, count1 = 0, count2 = 0;
        for (int x : nums) {
            if (x == 0) count0++;
            else if (x == 1) count1++;
            else count2++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (count0 > 0) {
                nums[i] = 0;
                count0--;
            } else if (count1 > 0) {
                nums[i] = 1;
                count1--;
            } else {
                nums[i] = 2;
                count2--;
            }
        }
    }
}