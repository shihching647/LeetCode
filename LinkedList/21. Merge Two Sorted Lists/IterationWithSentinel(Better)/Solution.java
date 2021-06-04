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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return l1;
        else if (l1 == null) return l2;
        else if (l2 == null) return l1;
        
        ListNode sentinel = new ListNode(0);
        ListNode cur = sentinel;
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode temp;
        while (p1 != null || p2 != null) {
            if (p1 == null || (p1 != null && p2 != null) && (p2.val < p1.val)) {
                temp = p2.next;
                cur.next = p2;
                cur.next.next = null;
                p2 = temp;
            } else {
                temp = p1.next;
                cur.next = p1;
                cur.next.next = null;
                p1 = temp;
            }
            cur = cur.next;
        }
        return sentinel.next;
    }
}