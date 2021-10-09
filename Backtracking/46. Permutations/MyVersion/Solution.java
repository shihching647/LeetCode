/**
 * 用一個marked[] array來標註哪個element是被使用過的
 *
 * Time complexity: O(N * N!)
 * Space complexity: O(N * N!)
 *
 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> wrap = new LinkedList<>();
        permute(nums, wrap, new LinkedList<>(), new boolean[nums.length]);
        return wrap;
    }
    
    private void permute(int[] nums, List<List<Integer>> wrap, List<Integer> list, boolean[] marked) {
        if (list.size() == nums.length) {
            wrap.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!marked[i]) {
                list.add(nums[i]);
                marked[i] = true;
                permute(nums, wrap, list, marked);
                // 用完要unmark
                list.remove(new Integer(nums[i]));
                marked[i] = false;
            }
        }
    }
}