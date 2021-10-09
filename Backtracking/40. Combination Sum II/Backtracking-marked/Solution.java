/**
 * 先將nums排序, 在求其組合. 因為會有重複的元素, 使用如47. Permutations II的marked的條件檢查避免重複.
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
        for (int i = start; i < nums.length && nums[i] <= target; i++) {
            // 重複的只explore一次就好, i == start時已經被explore過了, 所以當i > start時就跳過.
            // (同樣深度重複的元素只需要explire一次)
            if (i > start && nums[i] == nums[i - 1]) 
                continue;
            list.add(nums[i]);
            combinationSum(nums, i + 1, target - nums[i], list, wrap);
            list.remove(list.size() - 1);
        }
    }
}