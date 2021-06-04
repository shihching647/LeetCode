import java.util.Stack;

/**
 *  Using Stack:
 *  stack裡面一開始先放 -1,
 *  開始輪詢每個字元
 *  遇到 '(', push該index到stack裏;
 *  遇到 ')', 把最上面pop()掉
 *      若stack為空,  push該index到stack裏;
 *      若不為空, 用當前i扣掉stack最上面的元素, 計算出目前合法字串的長度, 更新maxCount
 *  Time complexity: O(n)
 *  Space complexity: O(n)
 */
public class Main {

    public static int longestValidParentheses(String s) {
        int maxCount = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(')
                stack.push(i);
            else  {
                stack.pop();
                if (stack.empty())
                    stack.push(i);
                else
                    maxCount = Math.max(maxCount, i - stack.peek());
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
