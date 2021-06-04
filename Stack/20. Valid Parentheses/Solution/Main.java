import java.util.Stack;

public class Main {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '[')
                stack.push(']');
            else if (c == '{')
                stack.push('}');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String input1 = "()";
        System.out.println(isValid(input1));  // true
        String input2 = "()[]{}";
        System.out.println(isValid(input2));  // true
        String input3 = "(]";
        System.out.println(isValid(input3));  // false
        String input4 = "([)]";
        System.out.println(isValid(input4));  // false
        String input5 = "{[]}";
        System.out.println(isValid(input5));  // true
        String input6 = "{";
        System.out.println(isValid(input6));  // false
        String input7 = "]";
        System.out.println(isValid(input7));  // false
    }
}
