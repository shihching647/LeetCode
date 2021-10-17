/**
 * 使用Backtracking
 * 重複怎麼辦?
 * 只有當前一個重複的數字被選中時, 那個branck才需探索下去 
 * 
 * Time complexity: O(N * 2^N)
 * Space complexity: O(N * 2^N)
 *
 */
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> wrap = new LinkedList<>();
        subsets(nums, 0, new LinkedList<>(), wrap);
        return wrap;
    }
    
    private void subsets(int[] nums, int start, LinkedList<Integer> list, List<List<Integer>> wrap) {
        wrap.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            list.add(nums[i]);
            subsets(nums, i + 1, list, wrap);
            list.removeLast();
        }
    }
}