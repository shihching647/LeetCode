/**
 * 使用Sliding window. 因為題目是求 |nums[i] - nums[j]|, 所以其實 [1,1,2,2] 與 [2,2,1,1]的答案會是一樣的
 * 也就是說跟順序沒關係, 所以可以直接進行排序.
 * 
 * Time complexity: O(NlogN)
 * Space complexity: O(1)
 *
 */
class Solution {
    public int countKDifference(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums); // sort
        int i = 0, j = 0;
        int ans = 0;
        while (i < n) {
            int num = nums[i];
            int count = 0;
            // 計算重複的個數count
            while (i < n && nums[i] == num) {
                i++;
                count++;
            }
            // 找到第一個nums[j]不小於num + k的數字
            while (j < n && nums[j] < num + k) {
                j++;
            }
            // 找到後當作start
            int start = j;
            // 計算nums[j] == num + k的數字有幾個
            while (j < n && nums[j] <= num + k) {
                j++;
            }
            ans += count * (j - start); // 加到ans
        }
        return ans;
    }
}