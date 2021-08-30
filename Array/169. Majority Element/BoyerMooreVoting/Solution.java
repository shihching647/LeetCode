/**
 * Boyer-Moore Voting Algorithm
 * 想法: 每個元素都投票給該數字, 最終majority的count一定會大於0
 * 實作: 統計count, 當元素相等時count + 1, 不同時count - 1, 當count被扣到為0時, 將majority換成當前元素, 留下來的一定是majority
 *
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
class Solution {
    public int majorityElement(int[] nums) {
        int majority = nums[0];
        int count = 1;
        for (int x : nums) {
            if (x == majority) {
                if (count++ > nums.length / 2)  // if count > n / 2 -> 直接return
                    return majority;
            } else if (--count == 0) {
                majority = x;
                count = 1;
            }
        }
        return majority;
    }
}