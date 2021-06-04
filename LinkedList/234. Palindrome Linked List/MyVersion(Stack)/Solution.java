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
        if (head.next == null)
            return true;
        
        Stack<ListNode> stack = new Stack<>();
        ListNode sentinel = new ListNode(9487, head);
        ListNode slow = sentinel, fast = sentinel;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            stack.push(slow);
        }
        
        if (fast == null)
            stack.pop();
        
        slow = slow.next;
        while (slow != null) {
            if (stack.pop().val != slow.val) return false;
            slow = slow.next;
        }
        return stack.empty();
    }
}