/**
 * 使用HashSet
 *
 * Time complexity: O(N)
 * Space complexity: O(N)
 */
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num))
                return true;
        }
        return false;
    }
}
