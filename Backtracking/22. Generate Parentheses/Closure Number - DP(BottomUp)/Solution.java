/**
 * 從Catalan number有一個生成公式為: Cn = Cn-1*C0 + Cn-2 * C1 +....+ C1 * Cn-2 + C0 * Cn - 1
 * 其中右邊的各項都可以看成是由 '(' + left + ')' + right 組合而成
 * 
 * 再加上bottom-up DP
 *
 * Time complexity: O(4 ^ N / n ^ (1/2)) (從limit Cn * n其中Cn為Catalan, Cn = (1 / n + 1)combinatiob(2n, n))
 * Space complexity: O(4 ^ N / n ^ (1/2))
 *
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String>[] table = new List[n + 1];
        List<String> list = new ArrayList<>();
        list.add("");
        table[0] = list;
        for (int i = 1; i <= n; i++) {
            list = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                for (String left : table[j]) {
                    for (String right : table[i - 1 - j]) {
                        list.add("(" + left + ")" + right);
                    }
                }
            }
            table[i] = list;
        }
        return table[n];
    }
}