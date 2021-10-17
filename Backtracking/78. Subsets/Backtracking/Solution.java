/**
 * 使用Backtracking
 * 
 * Time complexity: O(N * 2^N)
 * Space complexity: O(N * 2^N)
 *
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> wrap = new LinkedList<>();
        subsets(nums, 0, new LinkedList<>(), wrap);
        return wrap;
    }
    
    private void subsets(int[] nums, int start, LinkedList<Integer> list, List<List<Integer>> wrap) {
        wrap.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            subsets(nums, i + 1, list, wrap);
            list.removeLast();
        }
    }
}