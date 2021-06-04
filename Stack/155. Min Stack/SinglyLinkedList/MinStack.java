import java.util.Stack;

/**
 * Using singly-linked list :
 * Time complexity: push(), top(), pop(), getMin() in O(1)
 * Space complexity: O(n)
 */
class MinStack {

    private static class Node {
        int x;
        int min;
        Node next;

        Node(int x, int min, Node next) {
            this.x = x;
            this.min = min;
            this.next = next;
        }
    }

    private Node top;

    /** initialize your data structure here. */
    public MinStack() { }

    public void push(int val) {
        if (top == null) {
            top = new Node(val, val, null);
        } else {
            top = new Node(val, Math.min(top.min, val), top);
        }
    }

    public void pop() {
        top = top.next;
    }

    public int top() {
        return top.x;
    }

    public int getMin() {
        return top.min;
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