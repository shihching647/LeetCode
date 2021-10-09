/**
 * 從第一個元素開始, 每次將wrap裡的所有排列的list取出, 再將新的元素從index從0 ~ list.size()插入, 放回wrap中.
 * 如: {1,2,3}
 * 一開始 wrap = {1} 
 * i = 1, nums[i] = 2, wrap中的每個list的size = 1 -> 2種
 * {1,2}(來自{1}將2插入index 0), {2,1}(來自{1}將2插入index 1)
 * 
 * i = 2, nums[i] = 3, wrap中的每個list的size = 2 -> 6種
 * {3,1,2},{1,3,2},{1,2,3}((來自{1,2}將3插入index 0,1,2)),{3,2,1},{2,3,1},{2,1,3}((來自{2,1}將3插入index 0,1,2))

 * Time complexity: O(N * N!)
 * Space complexity: O(N * N!)
 *
 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> wrap = new LinkedList<>();
        if (nums.length == 0)
            return wrap;
        wrap.add(Arrays.asList(nums[0]));
        for (int i = 1; i < nums.length; i++) {
            List<List<Integer>> temp = new LinkedList<>();
            for (int j = 0; j <= i; j++) {
                for (List<Integer> list : wrap) {
                    LinkedList<Integer> newList = new LinkedList<>(list);
                    newList.add(j, nums[i]);
                    temp.add(newList);
                }
            }
            wrap = temp;
        }
        return wrap;
    }
}