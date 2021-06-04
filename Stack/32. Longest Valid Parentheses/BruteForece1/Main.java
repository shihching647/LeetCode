import java.util.Stack;

/**
 *  Brute Force:
 *  Time complexity: O(n^3), double for loop + isValid(O(n))
 *  Space complexity: O(n), stack size in isValid()
 */
public class Main {

    public static int longestValidParentheses(String s) {
        int maxCount = 0;
        for (int i = 0; i < s.length(); i++) {
            // valid parentheses must be pair
            for (int j = i + 2; j < s.length(); j += 2) {
                String subStr = s.substring(i, j);
                if (isValid(subStr))
                    maxCount = Math.max(maxCount, subStr.length()); // choose max
            }
        }
        return maxCount;
    }

    private static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (stack.isEmpty() || stack.pop() != c) return false;
        }
        return stack.isEmpty();
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
