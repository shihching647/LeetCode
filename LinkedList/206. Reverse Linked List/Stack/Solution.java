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
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        Stack<ListNode> stack = new Stack<>();
        
        ListNode p = head;
        while (p != null) {
            stack.push(p);
            p = p.next;
        }
        
        ListNode newHead = stack.pop();
        p = newHead;
        while (!stack.empty()) {
            p.next = stack.pop();
            p = p.next;
        }
        p.next = null;
        return newHead;
    }
}