/**
 * 使用Sliding Window pattern
 * 把window內的元素keep在一個set裡面，當set加入失敗就表示裡面已經有該元素.
 *
 * Time complexity: O(N)
 * Space complexity: O(K)
 */

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            // keep window長度為k
            if (i > k)
                set.remove(nums[i - k - 1]); // 移除最前面的數字
            if (!set.add(nums[i])) // 加入失敗就表示在長度k的window內有重複的element
                return true;
        }
        return false;
    }
}