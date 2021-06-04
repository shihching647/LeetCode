import java.util.Stack;

public class Main {

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (isNumber(token)) {
                stack.push(Integer.valueOf(token));
            } else {
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(evaluate(num1, num2, token));
            }
        }
        return stack.pop();
    }

    private static boolean isNumber(String str) {
        try {
            Integer.valueOf(str);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    private static int evaluate(int num1, int num2, String operator) {
        switch (operator) {
            case "+" : return num1 + num2;
            case "-" : return num1 - num2;
            case "*" : return num1 * num2;
            case "/" : return num1 / num2;
        }
        return 0;
    }

    public static void main(String[] args) {
        String[] token1 = {"2","1","+","3","*"};
        System.out.println(evalRPN(token1));  // 9
        String[] token2 = {"4","13","5","/","+"};
        System.out.println(evalRPN(token2));  // 6
        String[] token3 = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(token3)); // 22
    }
}
