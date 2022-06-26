/**
 * Using built-in linkedList library
 * Time complexity: push(), top(), pop(), getMin() in O(1)
 * Space complexity: O(n)
 */
class MinStack {
    
    private LinkedList<Integer> list;
    
    public MinStack() {
        this.list = new LinkedList<>();    
    }
    
    public void push(int val) {
        list.addFirst(val);
        if (list.size() != 1) {
            list.addLast(Math.min(list.getLast(), val));
        }
    }
    
    public void pop() {
        list.removeFirst();
        if (!list.isEmpty())
            list.removeLast();
    }
    
    public int top() {
        return list.getFirst();
    }
    
    public int getMin() {
        return list.getLast();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */