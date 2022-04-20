/**
 * 使用 HashMap + doubly linked list實作
 * 
 * Time complexity: O(1)
 * Space complexity: O(N)
 */
class LRUCache {

    private class Node {
        private int key;
        private int value;
        private Node pre, next;
        
        Node(int key, int value, Node pre, Node next) {
            this.key = key;
            this.value = value;
            this.pre = pre;
            this.next = next;
        }
    }
    
    private int capacity;
    private HashMap<Integer, Node> map;
    private Node head, tail; // 下一個要被移除的元素在第一個, 新的元素都往tail加
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0, 0, null, null);
        tail = new Node(0, 0, null, null);
        head.next = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        Node node = null;
        if (map.containsKey(key)) {
            node = map.get(key);
            removeFromLinkedList(node);
            insertTail(node);
        }
        return node != null ? node.value : -1;
    }
    
    public void put(int key, int value) {
        Node node = null;
        if (map.containsKey(key)) {
            node = map.get(key);
            node.value = value;
            removeFromLinkedList(node);
        } else {
            // remove LRU element
            if (map.size() == capacity) {
                map.remove(head.next.key); // remove from map
                removeFirst(); // remove first 
            }
            node = new Node(key, value, null, null);
            map.put(key, node);
        }
        insertTail(node);
    }
    
    // remove from linked list
    private void removeFromLinkedList(Node node) {
        Node pre = node.pre;
        Node next = node.next;
        pre.next = next;
        next.pre = pre; 
        node.pre = null;
        node.next = null;
    }
    
    // insert tail
    private void insertTail(Node node) {
        Node last = tail.pre;
        node.next = tail;
        node.pre = last;
        tail.pre = node;
        last.next = node;
    }
    
    // remove first
    private void removeFirst() {
        Node first = head.next;
        head.next = first.next;
        first.next.pre = head;
        first.next = null;
        first.pre = null;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */