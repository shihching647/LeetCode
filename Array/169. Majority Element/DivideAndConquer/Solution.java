/**
 * Divide and Conquer
 *
 * Time complexity: O(NlogN)
 * Space complexity: O(lgN)
 */
class Solution {
    public int majorityElement(int[] nums) {
        return majorityElement(nums, 0, nums.length - 1);
    }
    
    private int majorityElement(int[] nums, int lo, int hi) {
        // 當lo == hi時, 只有一個元素, majority為該元素
        if (lo == hi) {
            return nums[lo];
        }
        
        int mid = lo + (hi - lo) / 2;
        int leftMajority = majorityElement(nums, lo, mid);
        int rightMajority = majorityElement(nums, mid + 1, hi);
        
        // 當兩邊majority一樣時, majority為該元素
        if (leftMajority == rightMajority) {
            return leftMajority;
        }
        
        // else 掃過範圍內的元素, 看leftMajority, rightMajority誰才是majority
        int leftMajorityCount = countInRange(nums, lo, hi, leftMajority);
        int rightMajorityCount = countInRange(nums, lo, hi, rightMajority);

        return leftMajorityCount > rightMajorityCount ? leftMajority : rightMajority;
    }
    
    private int countInRange(int[] nums, int lo, int hi, int x) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == x)
                count++;
        }
        return count;
    }
}