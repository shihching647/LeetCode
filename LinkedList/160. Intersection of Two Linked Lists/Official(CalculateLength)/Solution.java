/**
 * As picture depict
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
        int lenA = length(headA);
        int lenB = length(headB);

        // p1 is the head of longer list, p2 is the shorter one
        ListNode p1, p2;
        if (lenA > lenB) {
            p1 = headA;
            p2 = headB;
        } else {
            p1 = headB;
            p2 = headA;
        }
        
        // offset p1 to align with p2
        int diff = Math.abs(lenA - lenB);
        while (diff > 0) {
            p1 = p1.next;
            diff--;
        }
        
        // find intersection
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
    
    private int length(ListNode node) {
        ListNode p = node;
        int len = 0;
        while (p != null) {
            p = p.next;
            len++;
        }
        return len;
    }
}