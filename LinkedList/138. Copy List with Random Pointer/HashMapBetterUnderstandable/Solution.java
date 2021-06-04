/**
 * Using a HashMap stores old node reference mapping to new node reference
 * Time complexity: O(2n)
 * Space complexity: O(n)
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
        // mapaping oldNode -> newNode
        HashMap<Node, Node> map = new HashMap<>();
        
        // first round: copy all nodes
        Node p = head;
        while (p != null) {
            map.put(p, new Node(p.val));
            p = p.next;
        }
        
        // second round: add next and random pointer ot newNode
        p = head;
        while (p != null) {
            Node newP = map.get(p);
            if (p.next != null) // is not necessary to check null
                newP.next = map.get(p.next);
            if (p.random != null) // is not necessary to check null
                newP.random = map.get(p.random);
            p = p.next;
        }
        return map.get(head);
    }
}
