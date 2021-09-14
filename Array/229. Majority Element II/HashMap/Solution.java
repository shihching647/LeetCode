/**
 * 使用HashMap紀錄每個數字出現的次數, 當次數 > n / 3時加入result(使用set)
 *
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for (int x : nums) {
            int count = countMap.getOrDefault(x, 0);
            countMap.put(x, ++count);
            if (count > nums.length / 3) {
                set.add(x);
            } 
        }
        return new LinkedList(set);
    }
}