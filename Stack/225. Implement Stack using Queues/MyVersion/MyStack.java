package stack.p225;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 *  Implement Stack using Queues
 *  push() - Time complexity: O(1), Space complexity: O(1)
 *  pop() - Time complexity: O(n), Space complexity: O(1)
 *  top() - Time complexity: O(n), Space complexity: O(1)
 */
class MyStack {

    /**
     * queue operation:
     * 1. offer(int x)
     * 2. poll()
     * 3. peek()
     * 4. size()
     * 5. isEmpty()
     **/
    private LinkedList<Integer> queue1;
    private LinkedList<Integer> queue2;
    private LinkedList<Integer> currentQueue, otherQueue;

    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
        currentQueue = queue1;
        otherQueue = queue2;
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if (!currentQueue.isEmpty())
            otherQueue.offer(currentQueue.poll());
        currentQueue.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (empty()) throw new NoSuchElementException("Stack is empty.");
        if (currentQueue.isEmpty())
            moveElements();
        return currentQueue.poll();
    }

    /** Get the top element. */
    public int top() {
        if (empty()) throw new NoSuchElementException("Stack is empty.");
        if (currentQueue.isEmpty())
            moveElements();
        return currentQueue.peek();
    }

    private void moveElements() {
        while (otherQueue.size() > 1) {
            currentQueue.offer(otherQueue.poll());
        }
        switchCurrentQueue();
    }

    private void switchCurrentQueue() {
        if (currentQueue == queue1) {
            currentQueue = queue2;
            otherQueue = queue1;
        } else {
            currentQueue = queue1;
            otherQueue = queue2;
        }
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
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