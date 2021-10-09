/**
 * 先將nums排序, 在求其組合. 因為會有重複的元素, 所以使用一個set檢查, 若有重複則不繼續搜索.
 * 
 * 參考: https://www.youtube.com/watch?v=RSatA4uVBDQ&ab_channel=HuaHua
 * Time complexity: O(N * 2 ^ N) (每個數字就是要選或不選兩種可能)
 * Space complexity: O(kN) (k為最後wrap list的長度)
 *
 */
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> wrap = new LinkedList<>();
        combinationSum(candidates, 0, target, new LinkedList<>(), wrap);
        return wrap;
    }
    
    private void combinationSum(int[] nums, int start, int target, List<Integer> list, List<List<Integer>> wrap) {
        if (target == 0) {
            wrap.add(new ArrayList<>(list));
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = start; i < nums.length && nums[i] <= target; i++) {
            if (set.add(nums[i])) {
                list.add(nums[i]);
                combinationSum(nums, i + 1, target - nums[i], list, wrap);
                list.remove(list.size() - 1);
            }
        }
    }
}