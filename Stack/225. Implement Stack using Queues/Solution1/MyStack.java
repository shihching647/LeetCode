package stack.p225;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 *  Implement Stack using Queues
 *  push() - Time complexity: O(1), Space complexity: O(1)
 *  pop() - Time complexity: O(n), Space complexity: O(n)
 *  top() - Time complexity: O(n), Space complexity: O(n)
 */
class MyStack {
    /**
     * queue operation:
     * 1. add()
     * 2. remove()
     * 3. size()
     * 4. isEmpty()
     **/
    private LinkedList<Integer> queue1;
    private LinkedList<Integer> queue2;
    private int top;

    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue1.add(x);
        top = x;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (empty()) throw new NoSuchElementException("Stack is empty.");
        while (queue1.size() > 1) {
            top = queue1.remove();
            queue2.add(top);
        }
        // switch queue1, queue2
        LinkedList<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return queue2.remove();
    }

    /** Get the top element. */
    public int top() {
        if (empty()) throw new NoSuchElementException("Stack is empty.");
        return top;
    }


    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        System.out.println(myStack.top()); // return 4
        System.out.println(myStack.pop()); // return 4
        System.out.println(myStack.pop()); // return 3
        System.out.println(myStack.pop()); // return 2
        System.out.println(myStack.pop()); // return 1
        System.out.println( myStack.empty()); // return true
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */