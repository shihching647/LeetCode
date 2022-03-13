/**
 * 有點類似Trie的preorder traversal.
      1         2        3    ...
      /\        /\       /\
   10 ...19  20...29  30...39   ....
 * 
 * 改成Iterative版本
 * 
 * 參考: https://leetcode.com/problems/lexicographical-numbers/discuss/86242/Java-O(n)-time-O(1)-space-iterative-solution-130ms
 * Time complexity: O(N)
 * Space complexity: O(1)
 *
 */
class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new LinkedList<>();
        int cur = 1;
        for (int i = 1; i <= n; i++) {
            list.add(cur);
            if (cur * 10 <= n) {
                cur *= 10; // left most node
            } else if (cur % 10 != 9 && cur + 1 <= n) { // traverse same level
                cur++;
            } else {
                // We should also consider n = 600, and the current number = 499,
                // the next number is 5 because there are all "9"s after "4" in "499" 
                // so we should divide 499 by 10 until the last digit is not "9".
                while ((cur / 10) % 10 == 9) {
                    cur /= 10;
                }
                cur = cur / 10 + 1;
            }
        }
        return list;
    }
}