/**
 * 類似DP的概念:
 * 先加入一個空list, 再一次加一個數字進來
 * 如: [1,2,3]
 * 一開始 -> wrap = []
 * 加入1  -> wrap = [], [1]
 * 加入2  -> wrap = [], [1], [2], [1,2]
 * 加入3  -> wrap = [], [1], [2], [1,2], [3], [2,3], [1,2,3]
 * 
 * 重複怎麼辦?
 * 參考:https://leetcode.wang/leetCode-90-SubsetsII.html 解法二
 * 大概的想法是: 當發現這個元素與前一個元素重複時, 只新增上一輪加入答案中的list就好.
 *
 * Time complexity: O(N * 2^N)
 * Space complexity: O(N * 2^N)
 *
 */
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> wrap = new LinkedList<>();
        wrap.add(new LinkedList<>());
        int lastStartPos = 1; // 每一輪開始新增的位置
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> temp = new LinkedList<>(wrap);
            int j = 0;
            // 若為重複的元素, j從上一輪新增的開始
            if (i > 0 && nums[i] == nums[i - 1]) {
                j = lastStartPos;
            }
            lastStartPos = wrap.size(); // 更新這一輪新增的位置
            for (; j < temp.size(); j++) {
                List<Integer> newList = new LinkedList<>(temp.get(j));
                newList.add(nums[i]);
                wrap.add(newList);
            }
        }
        return wrap;
    }
}