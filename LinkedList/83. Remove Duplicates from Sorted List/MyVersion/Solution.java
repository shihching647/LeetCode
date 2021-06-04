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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        
        ListNode pre = head;
        ListNode p = head.next;
        ListNode next;
        int cur = head.val;
        while (p != null) {
            next = p.next;
            if (p.val == cur) {
                // remove p from list
                pre.next = p.next;
                p.next = null;
            } else {
                // change current value
                cur = p.val;
                pre = p; // assign p to pre
            }
            p = next;
        }
        return head;
    }
}