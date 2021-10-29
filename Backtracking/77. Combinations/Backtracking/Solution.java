/**
 * Backtracking
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
        for (int i = start; i <= end; i++) {
            list.add(i);
            combine(i + 1, end, k, list, result);
            list.removeLast();
        }
        return;
    }
}