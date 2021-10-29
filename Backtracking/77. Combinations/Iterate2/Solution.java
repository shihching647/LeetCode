/**
 * Iterate(2):  類似P.46 insert方法
 * 
 * Time complexity: O(C(n, k))
 * Space complexity: O(C(n, k))
 *
 */
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        
        for (int i = 1; i <= n; i++) {
            result.add(Arrays.asList(i));
        }
        
        for (int i = 2; i <= k; i++) {
            List<List<Integer>> temp = new ArrayList<>();
            for (List<Integer> list : result) {
                for (int j = list.get(list.size() - 1) + 1; j <= n; j++) {
                    List<Integer> newList = new ArrayList<>(list);
                    newList.add(j);
                    temp.add(newList);
                }
            }
            result = temp;
        }
        return result;
    }
}