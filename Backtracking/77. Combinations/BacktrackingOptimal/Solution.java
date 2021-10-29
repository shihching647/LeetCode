/**
 * Backtracking with purning
 * 
 * Time complexity: O(C(n, k))
 * Space complexity: O(C(n, k))
 *
 */
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        combine(1, n, k, new LinkedList<>(), result);
        return result;
    }
    
    private void combine(int start, int end, int k, LinkedList<Integer> list, List<List<Integer>> result) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }
        // purning: 
        // 只有當 (還需要的個數) <= (後面剩下的個數)這個條件成立時, 才需繼續執行
        //   k - list.size()  <=  end - i + 1  
        //   -> i <= end - (k - list.size()) + 1 
        //   -> i <= end - (還需要的個數) + 1
        for (int i = start; i <= end - (k - list.size()) + 1; i++) {
            list.add(i);
            combine(i + 1, end, k, list, result);
            list.removeLast();
        }
        return;
    }
}