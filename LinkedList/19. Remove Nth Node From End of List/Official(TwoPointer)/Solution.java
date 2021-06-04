/**
 *
 * Two pointer, fast and slow pointer are (n + 1) node apart.
 * When fast == null, slow point to the previous node of removed node
 *
 * Time complexity: O(n)(worse case: L, best case: L / 2)
 * Space complexity: O(1)
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) 
            return null;
        
        ListNode sentinel = new ListNode(9487, head);
        ListNode slow = sentinel, fast = sentinel;
        
        // advance fast n + 1 node ahead to slow
        for (int i = 0; i <= n; i++) 
            fast = fast.next;
        
        // when fast == null, slow point to the previous node of removed node
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // remove the next node of slow
        slow.next = slow.next.next;
        return sentinel.next;
    }
    
}