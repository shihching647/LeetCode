import java.util.Stack;

/**
 * Using two stacks and one min:
 * Time complexity: push(), top(), pop(), getMin() in O(1)
 * Space complexity: O(n)
 */
class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    private int min;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        if (stack.empty() || val <= min) {
            min = val;
            minStack.push(min);
        }
        stack.push(val);
    }

    public void pop() {
        int top = stack.pop();
        if (top == getMin()) {
            minStack.pop();
            // 記得更新min
            if (!minStack.empty())  // 使用peek前, 要小心minStack不是empty
                min = minStack.peek();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(2147483646);
        stack.push(2147483646);
        stack.push(2147483647);
        System.out.println(stack.top());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        stack.push(2147483647);
        System.out.println(stack.top());
        System.out.println(stack.getMin());
        stack.push(-2147483648);
        System.out.println(stack.top());
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
    }
}