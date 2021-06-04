/**
 *  Use sentinel node and pointer manipulation
 *  Time complexity : O(n)
 *  Space complexity: O(1)
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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) 
            return head;
        
        ListNode sentinel = new ListNode(0, head);
        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode pre = sentinel;
        while (p1 != null && p2!= null) {
            ListNode next = p2.next;
            // swap
            pre.next = p2;
            p2.next = p1;
            p1.next = next;
            // next == null --> end of list
            if (next == null) break;
            pre = pre.next.next;
            p1 = p1.next;
            p2 = p1.next;
        }
        return sentinel.next;
    }
}