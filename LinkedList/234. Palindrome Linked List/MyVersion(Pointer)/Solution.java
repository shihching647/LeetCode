/**
 * My post: 
 * https://leetcode.com/problems/palindrome-linked-list/discuss/1212307/Java-O(n)-time-and-O(1)-space-solution-without-destroying-the-original-list 
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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        ListNode sentinel = new ListNode(0, head);
        ListNode fast = sentinel, slow = sentinel;
        ListNode pre = null, next = head;
        
        while (fast != null && fast.next != null) {
            // fast go with two steps
            fast = fast.next.next;
            // slow go with one step and reverse the first part of list
            if (fast != null) {
                pre = slow;
                slow = next;
                next = next.next;
                slow.next = pre;
            }
        }

        boolean result = true;
        ListNode p = fast == null ? next.next : next; // odd nodes: p start from next.next

        while (p != null) {
            // compare the p and slow is equal or not
            if (result && p.val != slow.val) {
                result = false;
            }
            // p go ahead
            p = p.next;
            // slow go back and restore the first part of list
            slow.next = next;
            next = slow;
            slow = pre;
            pre = pre.next;
        }
        return result;
    }
}