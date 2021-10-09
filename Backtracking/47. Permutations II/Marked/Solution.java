/**
 * 用一個marked[] array來標註哪個element是被使用過的.
 * 先將nums排序, 當遇到重複的元素時, 只有當前一個重複的元素有使用時, 該分支才需explore
 *
 * Time complexity: O(N * N!)
 * Space complexity: O(N * N!)
 *
 */
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> wrap = new LinkedList<>();
        boolean[] marked = new boolean[nums.length];
        List<Integer> list = new ArrayList<>(nums.length);
        Arrays.sort(nums);
        permute(nums, list, marked, wrap);
        return wrap;
    }
    
    private void permute(int[] nums, List<Integer> list, boolean[] marked, List<List<Integer>> wrap) {
        if (list.size() == nums.length) {
            wrap.add(new LinkedList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (marked[i]) continue;
            // 確保當有重複元素時, 只有第一個元素的那個分支會被explore(當前一個重複的元素有使用時, 該分支才需explore)
            if (i > 0 && nums[i - 1] == nums[i] && !marked[i - 1])  // marked[i - 1] 或是 !marked[i - 1]的說明請看圖片
                continue; 
            list.add(nums[i]);
            marked[i] = true;
            permute(nums, list, marked, wrap);
            list.remove(list.size() - 1);
            marked[i] = false;
        }
    }
}