/**
 * 從Catalan number有一個生成公式為: Cn = Cn-1*C0 + Cn-2 * C1 +....+ C1 * Cn-2 + C0 * Cn - 1
 * 其中右邊的各項都可以看成是由 '(' + left + ')' + right 組合而成
 *
 *
 * Time complexity: O(4 ^ N / n ^ (1/2)) (從limit Cn * n其中Cn為Catalan, Cn = (1 / n + 1)combinatiob(2n, n))
 * Space complexity: O(4 ^ N / n ^ (1/2))
 *
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new LinkedList<>();
        if (n == 0) {
            list.add("");
            return list;
        }
        for (int c = 0; c < n; c++) {
            for (String left : generateParenthesis(c)) {
                for (String right: generateParenthesis(n - 1 - c)) {
                    list.add("(" + left + ")" + right);
                }
            }
        }
        return list;
    }
}