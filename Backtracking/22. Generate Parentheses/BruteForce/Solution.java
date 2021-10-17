/**
 * Brute Force
 * 每個位置從 '(' 和 ')' 中選一個, 再檢查是否為合法的組合.
 * (一開始的想法是先產生一組'()()()', 再將其排列, 但這樣會有(2N)!種可能. )
 * 
 * Time complexity: O(2 ^ 2N)
 * Space complexity: O(N)
 *
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new LinkedList<>();
        generateParenthesis(new char[2 * n], 0, ans);
        return ans;
    }
    
    private void generateParenthesis(char[] a, int pos, List<String> ans) {
        if (pos == a.length) {
            if (isValid(a)) {
                ans.add(new String(a));
            }
            return;
        }
        a[pos] = '(';
        generateParenthesis(a, pos + 1, ans);
        a[pos] = ')';
        generateParenthesis(a, pos + 1, ans);
        return;
    }
    
    private boolean isValid(char[] a) {
        int balance = 0;
        for (char c : a) {
            if (c == '(') balance++;
            else balance--;
            if (balance < 0) return false;
        }
        return balance == 0;
    }
}