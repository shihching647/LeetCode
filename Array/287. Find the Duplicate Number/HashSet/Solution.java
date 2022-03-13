/**
 * 先排序再找重複
 * 
 * Time complexity: O(N)
 * Space complexity: O(N)
 */
class Solution {
    public int findDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num))
                return num;
        }
        throw new IllegalArgumentException("");
    }
}