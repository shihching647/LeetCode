/**
 *
 * First, calculate length and reomve the nth node from end. 
 * Time complexity: O(n) (2L−n)
 * Space complexity: O(1)
 *
 */


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) 
            return null;
       
        int len = calculateLength(head);
        ListNode sentinel = new ListNode(0, head);
        ListNode p = sentinel;
        int i = 0;
        while (i < len - n) {
            p = p.next;
            i++;
        }
        p.next = p.next.next;
        return sentinel.next;
    }
    
    private int calculateLength(ListNode node) {
        int len = 0;
        while (node != null) {
            node = node.next;
            len++;
        }
        return len;
    }
}