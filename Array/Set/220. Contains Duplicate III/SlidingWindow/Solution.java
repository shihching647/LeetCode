/**
 * 使用Sliding Window pattern
 * 把window內的元素keep在一個TreeSet裡面, 再加入前先取得TreeSet的針對nums[i]的ceiling與floor
 * 當set加入失敗就表示裡面已經有該元素(t == 0) or ceiling - nums[i] <= t or nums[i] - floor <= t.
 *
 * Time complexity: O(NlogK)
 * Space complexity: O(K)
 */

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // 要用long, 因為 -2^31 <= nums[i] <= 2^31 - 1, 差值若用Integer裝會overflow
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long num = new Long(nums[i]);
            if (i > k)
                set.remove(new Long(nums[i - k - 1]));
            Long ceiling = set.ceiling(num);
            Long floor = set.floor(num);
            if (!set.add(num) || ceiling != null && ceiling - num <= t || floor != null && num - floor <= t)
                return true;
        }
        return false;
    }
}