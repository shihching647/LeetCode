/**
 *
 * Two pointer slow, fast, which take 1, 2 steps each time respectively
 * Time complexity: O(n), Actually is O(N+K) which N = non-cycle length , K = cyclic length 
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
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) { // fast will terminal first
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) // meet means there is a cycle
                return true;
        }
        return false;
    }
}