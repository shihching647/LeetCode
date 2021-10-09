/**
 * Backtracking
 * 
 * Time complexity: O(N * 2 ^ N) (每個數字就是要選或不選兩種可能)
 * Space complexity: O(kN) (k為最後wrap list的長度)
 *
 */
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> wrap = new LinkedList<>();
        combinationSum(k, n, 1, new LinkedList<>(), wrap);
        return wrap;
    }
    
    private void combinationSum(int k, int n, int start, LinkedList<Integer> list, List<List<Integer>> wrap) {
        if (k == 0) {
            if (n == 0) wrap.add(new LinkedList(list)); // O(N) time
            return;
        }
        for (int i = start; i <= 9 && i <= n; i++) {
            list.add(i);
            combinationSum(k - 1, n - i, i + 1, list, wrap);
            list.removeLast();
        }
    }
}