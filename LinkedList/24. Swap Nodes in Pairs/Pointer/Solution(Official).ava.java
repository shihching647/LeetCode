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
        ListNode p = sentinel;
        while (p.next != null && p.next.next != null) {
            ListNode first = p.next;
            ListNode second = first.next;
            first.next = second.next;
            second.next = first;
            p.next = second;
            p = first;
        }
        return sentinel.next;
    }
}   