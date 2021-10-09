/**
 * 求組合時, 需要一個start的參數, 確保都是往後取, 避免排列.
 *
 * Time complexity: O(C(num.length, d))
 * Space complexity: O(C(num.length, d))
 *
 */
class Solution {

    public List<List<Integer>> combination(int[] nums) {
        List<List<Integer>> wrap = new LinkedList<>();
        combination(nums, 0, new ArrayList<>(nums.length), wrap, 2); 
        return wrap;
    }
    
    // 求C(num.length, d)
    private void combination(int[] nums, int start, List<Integer> list, List<List<Integer>> wrap, int d) {
        if (list.size() == d) {
            wrap.add(new ArrayList(list));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            combination(nums, i + 1, list, wrap, d);
            list.remove(list.size() - 1);
        }
    }
}