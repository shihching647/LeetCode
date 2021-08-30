/**
 * 隨機選一個index rand, 檢查她是不是majority.
 *
 * Time complexity: worse case: O(無窮大), average case: O(n) (因為超過一半都是majority, 所以理論上每兩次就有一次選到majority)
 * Space complexity: O(1)
 */

class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        while (true) {
            int rand = (int) (Math.random() * n);
            int ans = nums[rand];
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] == ans) count++;
                if (count > n / 2)
                    return ans;
            }
        }
    }
}