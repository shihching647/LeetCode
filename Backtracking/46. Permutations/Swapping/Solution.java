/**
 * 用d代表哪一個index的數字已經確定, 並把其他的數字倆倆都swap過一次.
 *
 * Time complexity: O(N * N!)
 * Space complexity: O(N * N!)
 *
 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> wrap = new LinkedList<>();
        permute(nums, wrap, 0); // 使用d(recurse的深度)當作固定的index
        return wrap;
    }
    
    private void permute(int[] nums, List<List<Integer>> wrap, int d) {
        if (d == nums.length) {
            List<Integer> list = new ArrayList<>(nums.length);
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
            }
            wrap.add(list);
            return;
        }
        // d之前的數字已經固定了
        for (int i = d; i < nums.length; i++) {
            swap(nums, d, i);
            permute(nums, wrap, d + 1);
            swap(nums, i, d); // backtrack(回朔到原本的狀態)
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}