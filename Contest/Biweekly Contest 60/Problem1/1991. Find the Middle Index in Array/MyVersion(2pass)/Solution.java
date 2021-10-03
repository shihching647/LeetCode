/**
 * 先算1 ~ n的rightSum, 再由左到右check leftSum是否等於sumRight
 * 
 * Time complexity: O(N) (2-pass)
 * Space complexity: O(1)
 *
 */


class Solution {
    public int findMiddleIndex(int[] nums) {
        int n = nums.length;
        int rightSum = 0;
        for (int i = 1; i < n; i++)
            rightSum += nums[i];
        
        int leftSum = 0;
        for (int i = 0; i < n; i++) {
            if (leftSum == rightSum)
                return i;
            leftSum += nums[i];
            rightSum -= (i + 1 < n ? nums[i + 1] : 0);
        }
        return -1;
    }
}