import java.util.*;

/**
* Only use one queue.
**/
class MyStack {

    /**
     * queue operation: 
     * 1. add()
     * 2. remove()
     * 3. size()
     * 4. isEmpty()
     * 5. peekFirst()
     **/
    
    private LinkedList<Integer> q;

    /** Initialize your data structure here. */
    public MyStack() {
        q = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        q.add(x);
        for (int i = 0; i < q.size() - 1; i++) {
            q.add(q.remove());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (empty()) throw new NoSuchElementException("Stack is empty.");
        return q.remove();
    }

    /** Get the top element. */
    public int top() {
        if (empty()) throw new NoSuchElementException("Stack is empty.");
        return q.peekFirst();
    }


    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q.isEmpty();
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