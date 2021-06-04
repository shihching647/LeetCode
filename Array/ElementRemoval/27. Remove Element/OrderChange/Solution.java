/**
 * Order can be changed, so
 * if we encounter nums[i] == val, we assign the element with last element and decrease the length n by one
 * else we continue i increase i pointer by one.
 * By doing this, we can avoid unnecessary copy operation by the other solution.
 */
class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1]; // override by last element
                n--;  // decrease n by one
            } else {
                i++;
            }
        }
        return i;
    }
}