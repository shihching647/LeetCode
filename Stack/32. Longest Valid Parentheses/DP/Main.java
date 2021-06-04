/**
 *  Dynamic programming:
 *  Time complexity: O(n)
 *  Space complexity: O(n)
 */
public class Main {

    public static int longestValidParentheses(String s) {
        int maxCount = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxCount = Math.max(maxCount, dp[i]);
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        String input1 = "(()";
        System.out.println(longestValidParentheses(input1));  // 2
        String input2 = ")()())";
        System.out.println(longestValidParentheses(input2));  // 4
        String input3 = "";
        System.out.println(longestValidParentheses(input3));  // 0
        String input4 = "(())";
        System.out.println(longestValidParentheses(input4));  // 4
        String input5 = "((()()))";
        System.out.println(longestValidParentheses(input5));  // 8
        String input6 = "(()()(()))";
        System.out.println(longestValidParentheses(input6));  // 10
        String input7 = ")))))((())())";
        System.out.println(longestValidParentheses(input7));  // 8
        String input8 = "(())(((((((";
        System.out.println(longestValidParentheses(input8));  // 4
        String input9 = "))()()(())(";
        System.out.println(longestValidParentheses(input9));  // 8
        String input10 = "()()())))(()()()())(()(())()";
        System.out.println(longestValidParentheses(input10));  // 10
    }
}
