/**
 * 用d代表哪一個index的數字已經確定, 並把其他的數字倆倆都swap過一次.
 * 並使用一個HashSet存已經出現過的數字, 重複出現就不往下搜索.
 *
 * Time complexity: O(N * N!)
 * Space complexity: O(N * N!)
 *
 */
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> wrap = new LinkedList<>();
        permute(nums, wrap, 0);
        return wrap;
    }
    
    private void permute(int[] nums, List<List<Integer>> wrap, int d) {
        if (d == nums.length) {
            List<Integer> list = new ArrayList<>(nums.length);
            for (int i = 0; i < nums.length; i++)
                list.add(nums[i]);
            wrap.add(list);
            return;
        }
        
        HashSet<Integer> set = new HashSet<>();
        for (int i = d; i < nums.length; i++) {
            // 如果set加成功, 代表第一次搜索, 才往下dfs, 重複的就不搜索
            if (set.add(nums[i])) {
                swap(nums, i, d);
                permute(nums, wrap, d + 1);
                swap(nums, i, d);
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}