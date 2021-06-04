/**
 * Time complexity: O(n)
 * Space complexity: O(1)
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
    public ListNode removeElements(ListNode head, int val) {
        ListNode sentinel = new ListNode(0, head);
        ListNode p = head;
        ListNode newHead = sentinel;
        while (p != null) {
            if (p.val != val){
                newHead.next = p;
                newHead = newHead.next;
            }
            p = p.next;
        }
        newHead.next = null;
        return sentinel.next;
    }
}