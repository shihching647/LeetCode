/**
 * 有點類似Trie的preorder traversal.
      1         2        3    ...
      /\        /\       /\
   10 ...19  20...29  30...39   ....
 * 
 * Time complexity: O(N)
 * Space complexity: O(logN)
 *
 */
class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= 9; i++) {
            helper(i, n, list);
        }
        return list;
    }
    
    private void helper(int cur, int n, List<Integer> list) {
        if (cur > n)
            return;
        list.add(cur);
        for (int i = 0; i <= 9; i++) {
            if (cur * 10 + i > n)
                return;
            helper(cur * 10 + i, n, list);
        }
    }
}