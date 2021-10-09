/**
 * 先將nums排序, 在求其組合.
 * 
 * 參考: https://www.youtube.com/watch?v=zIY2BWdsbFs&ab_channel=HuaHua
 * Time complexity: O(N * 2^N)
 * Space complexity: O(k * N) (k是wrap list的長度)
 *
 */
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> wrap = new LinkedList<>();
        Arrays.sort(candidates);
        combinationSum(candidates, target, 0, new ArrayList<>(candidates.length), wrap);
        return wrap;
    }
    
    // 求組合時, 多一個start的參數, 之後的元素只能從start之後選擇
    private void combinationSum(int[] nums, int target, int start, List<Integer> list, List<List<Integer>> wrap) {
        if (target == 0) {
            wrap.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (nums[i] > target) // 因為nums已經排序過, 所以當nums[i] > target時, 後面的都不可能了, 可以直接return
                return;
            list.add(nums[i]);
            combinationSum(nums, target - nums[i], i, list, wrap);
            list.remove(list.size() - 1);
        }
    }
}