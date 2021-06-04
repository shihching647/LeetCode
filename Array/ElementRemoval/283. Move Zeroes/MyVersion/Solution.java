class Solution {
    public void moveZeroes(int[] nums) {
        // remove all zeros
        int j = 0;
        for (int n : nums) {
            if (n != 0)
                nums[j++] = n;
        }
        // j之後全部補0
        while (j < nums.length) {
            nums[j++] = 0;
        }
    }
}