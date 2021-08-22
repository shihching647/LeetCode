/**
 * Resursion version (與153完全一模一樣, 只是Time變成O(N), worse case發生在全部都為一樣的元素時)
 * 
 * 參考: https://www.youtube.com/watch?v=P4r7mF1Jd50&ab_channel=HuaHua
 * 
 * Time complexity: O(N) 
 * Space complexity: O(logN)
 *
 */
class Solution {
    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length - 1);
    }
    
    private int findMin(int[] nums, int l, int r) {
        // 元素小於等於2個
        if (r - l <= 1)
            return Math.min(nums[l], nums[r]);
        
        // 若是排好序, 最左邊的element會小於最右邊的element
        if (nums[l] < nums[r])
            return nums[l];
        
        int mid = l + (r - l) / 2;
        return Math.min(findMin(nums, l, mid - 1), findMin(nums, mid, r));
    }
}