import java.util.Stack;

/**
 *  神奇解法:
 *  1.兩個指標left, right, 輪詢每個字元
 *  遇到 '(', left++
 *  遇到 ')', right++
 *  當left == right時, 更新maxCount
 *  當left > right時, 重算
 *  2.同樣的方法再從右跑到左邊
 *  Time complexity: O(n)
 *  Space complexity: O(1)
 */
public class Main {

    public static int longestValidParentheses(String s) {
        int left = 0, right = 0, maxCount = 0;

        // 由左而右先跑一次
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                left++;
            else
                right++;

            if (left == right) // 有match, 更新maxCount
                maxCount = Math.max(maxCount, 2 * right);
            else if (right > left) { // 如 ())))))))這種例子, right > left 就要重算
                left = right = 0;
            }
        }

        // 由右而左再跑一次
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(')
                left++;
            else
                right++;

            if (left == right) // 有match, 更新maxCount
                maxCount = Math.max(maxCount, 2 * left);
            else if (left > right) {
                left = right = 0; // 如 ((((((()這種例子, left > right 就要重算
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
