/**
 *  Using stack:
 *  Time complexity: O(n)
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
    public void reorderList(ListNode head) {
        if (head.next == null)
            return;
        
        // go throught whole list, and push all element to stack, get the length of list
        int n = 0;
        Stack<ListNode> stack = new Stack<>();
        ListNode c = head;
        while (c != null) {
            stack.push(c);
            c = c.next;
            n++;
        }
        // concatenate half part of list and half part of stack
        c = head;
        for (int i = 0; i < n / 2; i++) {
            ListNode temp = c.next;
            c.next = stack.pop();
            c.next.next = temp;
            c = c.next.next;
        }
        // if length is odd, one more pop should be called
        if (n % 2 == 1) {
            c.next = stack.pop();
            c = c.next;
        }
        // set next of last node to null
        c.next = null;
    }
}