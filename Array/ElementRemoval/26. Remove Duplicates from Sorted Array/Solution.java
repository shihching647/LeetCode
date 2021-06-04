class Solution {
    public int removeDuplicates(int[] nums) {
        if (num.length == 0) return 0;
        int current = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] != nums[i]) {
                nums[current++] = nums[i + 1];
            }
        }
        return current;
    }
}