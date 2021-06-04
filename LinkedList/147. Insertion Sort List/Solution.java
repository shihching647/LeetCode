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
    public ListNode insertionSortList(ListNode head) {
        ListNode sentinel = new ListNode(0); // to stroe the sorted list
        ListNode current = head;
        
        while(current != null) {
            
            // find the position in sorted list, where current node should be inserted
            ListNode p = sentinel;
            while (p.next != null && p.next.val < current.val) {
                p = p.next;
            }
            
            // insert the current node
            ListNode next = current.next;
            current.next = p.next;
            p.next = current;
            
            // current node go to next
            current = next;
        }
        
        return sentinel.next;
    }
}