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

        // first round: create new linked list without random pointer
        Node newHead = new Node(head.val);
        map.put(head, newHead);
        Node newP = newHead;
        Node p = head;
        while (p.next != null) {
            newP.next = new Node(p.next.val);
            p = p.next;
            newP = newP.next;
            map.put(p, newP);
        }

        // second round: add random pointer to every new node.
        newP = newHead;
        p = head;
        while (p != null) {
            if (p.random != null) {
                newP.random = map.get(p.random);
            }
            p = p.next;
            newP = newP.next;
        }
        return newHead;
    }
}
