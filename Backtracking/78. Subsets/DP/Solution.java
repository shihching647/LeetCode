/**
 * 類似DP的概念:
 * 先加入一個空list, 再一次加一個數字進來
 * 如: [1,2,3]
 * 一開始 -> wrap = []
 * 加入1  -> wrap = [], [1]
 * 加入2  -> wrap = [], [1], [2], [1,2]
 * 加入3  -> wrap = [], [1], [2], [1,2], [3], [2,3], [1,2,3]
 *
 * Time complexity: O(N * 2^N)
 * Space complexity: O(N * 2^N)
 *
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> wrap = new LinkedList<>();
        wrap.add(new ArrayList<>());
        
        for (int num : nums) {
            List<List<Integer>> temp = new LinkedList<>(wrap);
            for (List<Integer> list : temp) {
                List<Integer> newList = new LinkedList<>(list);
                newList.add(num);
                wrap.add(newList);
            }
        }
        return wrap;
    }
}