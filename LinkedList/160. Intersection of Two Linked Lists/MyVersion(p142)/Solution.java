/**
 * Go through one list and concatneate the end node with head
 * and the problem becomes finding the node where the cycle 
 * begins (Problem.142)
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // go through list A and 
        ListNode p = headA;
        while (p.next != null) {
            p = p.next;
        }
        p.next = headA; // concatneate end node of list A with head of list A

        
        // the problem become find the node where the cycle begins (Problem.142)
        ListNode fast = headB;
        ListNode slow = headB;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                while (fast != headB) {
                    fast = fast.next;
                    headB = headB.next;
                }
                p.next = null; // disconnect end node of list A with head of list A
                return fast;
            }
        }
        p.next = null; // disconnect end node of list A with head of list A
        return null;  // no intersection
    }
}