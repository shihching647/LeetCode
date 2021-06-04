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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        
        ListNode sentinel = new ListNode(0, head);
        ListNode pre = sentinel;
        ListNode p = head;
        while (p != null) {
            
            if (p.next != null && p.next.val == p.val) {
                while (p.next != null && p.next.val == p.val) {
                    p = p.next;
                }
                pre.next = p.next; // override pre.next, not forwarding
            } else {
                pre = pre.next; // pre forwarding
            }
            
            p = p.next;
        }
        return sentinel.next;
    }
}