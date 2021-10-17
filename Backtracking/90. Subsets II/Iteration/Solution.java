/**
 * 想法: 
 * 當有重複數字出現的時候，我們不再按照之前的想法走，單獨考慮這種情況。
 * 當有n個重複數字出現，實際上就是在出現重複數字之前的所有解中，分別加1個重複數字，2個重複數字，3個重複數字
 * 
 * 參考:https://leetcode.wang/leetCode-90-SubsetsII.html 解法二
 * Time complexity: O(N * 2^N)
 * Space complexity: O(N * 2^N)
 *
 */
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> wrap = new LinkedList<>();
        wrap.add(new LinkedList<>());
        for (int i = 0; i < nums.length; i++) {
            int repeatCount = 1;
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                repeatCount++;
                i++;
            }
            int size = wrap.size();
            for (int j = 0; j < size; j++) {
                List<Integer> newList = new LinkedList<>(wrap.get(j));
                for (int t = 0; t < repeatCount; t++) {
                    newList.add(nums[i]);
                    wrap.add(new LinkedList<>(newList));
                }
            }
        }
        return wrap;
    }
}