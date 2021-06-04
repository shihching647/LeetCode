/**
 *  Use a hash set store duplicate values, and remove all duplicate nodes
 *  Time complexity : O(2n)
 *  Space complexity: O(n)
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
        
        // 1. go through all nodes, store duplicate values in a set, and remain one left
        HashSet<Integer> set = new HashSet<>();
        ListNode p = head;
        while (p != null && p.next != null) {
            if (p.val == p.next.val) {
                p.next = p.next.next;
                set.add(p.val);
            } 
            p = p.next;
        }
        
        // 2. remove nodes which val in set
        ListNode newHead = null;
        ListNode newP = newHead;
        p = head;
        while (p != null) {
            while (p != null && set.contains(p.val)) {
                p = p.next;
            }
            if (newP == null) {
                newHead = p;
                newP = p;
            } else {
                newP.next = p;
                newP = newP.next;
            }
            if (p != null) // for case like [1,2,2], p will equal to null after inner while loop
                p = p.next;
        }
        return newHead;
    }
}