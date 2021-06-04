/**
 * 1. copy new Node as old node's next node
 * 2. copy old random pointer to new random pointer
 * 3. seperate old nodes and new nodes
 * Time complexity: O(3n)
 * Space complexity: O(1)
 */

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) 
            return head;
        
        // 1. copy new Node as old node's next node
        Node p = head;
        while (p != null) {
            Node temp = p.next;
            p.next = new Node(p.val);
            p.next.next = temp;
            p = temp;
        }
        
        // 2. copy old random pointer to new random pointer
        p = head;
        while (p != null) {
            Node newNode = p.next;
            if (p.random != null) {
                newNode.random = p.random.next;
            }
            p = p.next.next;
        }
        
        // 3. seperate old nodes and new nodes
        p = head;
        Node newHead = head.next;
        Node newP = newHead;
        while (p != null) {
            if (p.next != null)
                p.next = p.next.next;
            if (newP.next != null)
                newP.next = newP.next.next;
            p = p.next;
            newP = newP.next;
        }
        
        return newHead;
    }
}
