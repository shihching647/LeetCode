/**
 *
 * Using a hash set store the elements have existed
 * Time complexity: O(n)
 * Space complexity: O(1)
 *
 */


/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode p = head;
        while (p != null) {
            ListNode temp = p.next;
            if (p == temp) // if p == p.next means already visited
                return true;
            p.next = p; // ponite next to itself
            p = temp;
        }
        return false;
    }
}