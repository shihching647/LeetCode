class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums) {
            if (i < 2 || n > nums[i - 2]) // 只需要檢查前兩格就好
                nums[i++] = n;
        }
        return i;
    }
}