/**
 * 從Catalan number有一個生成公式為: Cn = Cn-1*C0 + Cn-2 * C1 +....+ C1 * Cn-2 + C0 * Cn - 1
 * 其中右邊的各項都可以看成是由 '(' + left + ')' + right 組合而成
 *
 * 在使用Memo避免重複計算
 *
 * Time complexity: O(4 ^ N / n ^ (1/2)) (從limit Cn * n其中Cn為Catalan, Cn = (1 / n + 1)combinatiob(2n, n))
 * Space complexity: O(4 ^ N / n ^ (1/2))
 *
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String>[] memo = new List[n + 1];
        List<String> list = new LinkedList<>();
        list.add("");
        memo[0] = list;
        generateParenthesis(n, memo);
        return memo[n];
    }
    
    private List<String> generateParenthesis(int n, List<String>[] memo) {
        if (memo[n] != null) {
            return memo[n];
        }
        List<String> list = new LinkedList<>();
        for (int c = 0; c < n; c++) {
            List<String> leftList = generateParenthesis(c, memo);
            List<String> rightList = generateParenthesis(n - 1 - c, memo);
            memo[c] = leftList;
            memo[n - 1 - c] = rightList;
            for (String left : leftList) {
                for (String right: rightList) {
                    list.add("(" + left + ")" + right);
                }
            }
        }
        memo[n] = list;
        return list;
    }
    
}