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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        ListNode p = even.next;
        while (p != null && p.next != null) {
            if (p != null) {
                odd.next = p;
                odd = odd.next;
            }
            if (p.next != null) {
                even.next = p.next;
                even = even.next;
            }
            p = p.next.next;
        }
        if (p != null) {
            odd.next = p;
            odd = odd.next;
        }
        even.next = null;
        odd.next = evenHead;
        return head;
    }
}