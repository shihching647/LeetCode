/**
 *  Use sentinel node to represent the sorted list
 *  Time complexity: O(n^2)
 *  Space complexity: O(n)
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
    public ListNode sortList(ListNode head) {
        // selection sort
        if (head == null || head.next == null)
            return head;
        
        ListNode sentinel = new ListNode();
        ListNode sortedList = sentinel;
        ListNode dummy = new ListNode(0, head);
        
        while (dummy.next != null) {
            ListNode p = dummy;
            ListNode minNode = dummy.next, pre = dummy, next = minNode.next;
            while (p.next != null) {
                if (minNode.val > p.next.val) {
                    pre = p;
                    minNode = p.next;
                    next = p.next.next;
                }
                p = p.next;
            }

            pre.next = next;

            minNode.next = sortedList.next;
            sortedList.next = minNode;
            sortedList = sortedList.next;
        }
        return sentinel.next;
    }
}