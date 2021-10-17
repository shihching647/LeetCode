/**
 * Backtracking
 * 使用目前的'('個數(openCount)和')'的個數(closeCount)來確保正確性.
 * 必須滿足下列兩個條件:
 * 1. openCount <= n
 * 2. closeCount <= openCount
 * 
 * Time complexity: O(4 ^ N / n ^ (1/2)) (從limit Cn * n其中Cn為Catalan, Cn = (1 / n + 1)combinatiob(2n, n))
 * Space complexity: O(4 ^ N / n ^ (1/2))
 *
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new LinkedList<>();
        generateParenthesis(n, 0, 0, new StringBuilder(), ans);
        return ans;
    }
    
    private void generateParenthesis(int n, int openCount, int closeCount, StringBuilder sb, List<String> ans) {
        if (sb.length() == n * 2) {
            ans.add(sb.toString());
            return;
        }
        
        if (openCount < n) {
            sb.append("(");
            generateParenthesis(n, openCount + 1, closeCount, sb, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
        
        if (openCount > closeCount) {
            sb.append(")");
            generateParenthesis(n, openCount, closeCount + 1, sb, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
        return;
    }
}