import java.util.Stack;

public class Main {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty())  return false; // for case only contains right parenthesis
                char top = stack.pop();
                if (top == '(' && c != ')') return false;
                if (top == '[' && c != ']') return false;
                if (top == '{' && c != '}') return false;
            }
        }
        return stack.isEmpty(); // empty means parentheses match
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
