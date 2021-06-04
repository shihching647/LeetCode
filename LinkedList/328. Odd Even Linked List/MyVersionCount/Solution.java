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
        int i = 3;
        while (p != null) {
            if (i % 2 == 1) {
                odd.next = p;
                odd = odd.next;
            } else {
                even.next = p;
                even = even.next;
            }
            i++;
            p = p.next;
        }
        even.next = null;
        odd.next = evenHead;
        return head;
    }
}