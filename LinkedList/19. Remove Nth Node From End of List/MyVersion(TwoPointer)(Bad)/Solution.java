/**
 *
 * Two pointer, one(fast) to calculate length, and in the mean time
 * the slow will point to the middle node.
 * If n < len / 2 => p start from sentinel;
 * else p start from slow.
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
        
        ListNode sentinel = new ListNode(0, head);
        ListNode slow = sentinel;
        ListNode fast = sentinel;
        int len = 0;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            if (fast != null) len += 2;
            else len += 1;
            slow = slow.next;
        }
        
        ListNode p = (n < len / 2) ? slow : sentinel;
        int i = (n < len / 2) ? Math.abs(n - len / 2) : len - n;
        while (i >= 1) {
            p = p.next;
            i--;
        }
        p.next = p.next.next;
        return sentinel.next;
    }
    
}