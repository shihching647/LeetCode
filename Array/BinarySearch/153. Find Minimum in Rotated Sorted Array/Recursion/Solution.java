/**
 * Resursion version
 * 
 * 參考: https://www.youtube.com/watch?v=P4r7mF1Jd50&ab_channel=HuaHua
 * 
 * Time complexity: O(logN) (因為對於任何一次呼叫, 一定會有其中一邊的array是排序好的, 所以 T(n) = T(1) + T(n / 2))
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