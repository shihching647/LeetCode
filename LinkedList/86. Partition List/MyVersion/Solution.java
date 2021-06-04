/**
 * Use sentinel node and pointer manipulation 
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
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null)
            return head;
        
        ListNode sentinel1 = new ListNode(0);
        ListNode equalOrLess = sentinel1;
        ListNode sentinel2 = new ListNode(0);
        ListNode greater = sentinel2;
        ListNode p = head;
        while (p != null) {
            if (p.val < x) {
                equalOrLess.next = p;
                equalOrLess = equalOrLess.next;
            } else {
                greater.next = p;
                greater = greater.next;
            }
            p = p.next;
        }
        // concatenate two equalOrLess list and greater list
        equalOrLess.next = sentinel2.next;
        // set the last node of greater list to null
        greater.next = null;
        return sentinel1.next;
    }
}