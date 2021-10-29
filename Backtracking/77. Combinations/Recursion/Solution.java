/**
 * Recursion:  C(n, k) = C(n - 1, k - 1) + C(n - 1, k)
 * 要求C(n, k)的所有組合 = 
 * 1. 從n - 1裡面選k - 1, 再加上數字n
 * 2. 從n - 1裡面直接選k個數.
 * 
 * Time complexity: O(C(n, k))
 * Space complexity: O(C(n, k))
 *
 */
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        // base case
        if (k == 0 || n == k) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 1; i <= k; i++) {
                temp.add(i);
            }
            return new ArrayList<>(Arrays.asList(temp));
        }
        // 1. 從n - 1裡面選k - 1, 再加上數字n
        List<List<Integer>> result = combine(n - 1, k - 1);
        for (List<Integer> list : result) {
            list.add(n);
        }
        // 2. 從n - 1裡面直接選k個數.
        result.addAll(combine(n - 1, k));
        return result;
    }
}