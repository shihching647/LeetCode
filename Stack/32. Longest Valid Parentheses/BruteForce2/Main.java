import java.util.Stack;

/**
 *  Brute Force:
 *  Time complexity: O(n^2), double for loop
 *  Space complexity: O(1), using one variable count instead of stack
 */
public class Main {

    public static int longestValidParentheses(String s) {
        int maxCount = 0;
        for (int i = 0; i < s.length(); i++) {
            // minor improvement: already find the maxCount, return maxCount
            if (maxCount > s.length() - i + 1)
                return maxCount;
            int count = 0;
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                // using count as stack size
                if (c == '(') count++;
                else count--;

                // there are more ')' than '(', is invalid already
                if (count < 0) break;

                // if stack is empty, update maxCount
                if (count == 0) {
                    maxCount = Math.max(maxCount, j - i + 1); // j - i + 1 == length of substring
                }
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
