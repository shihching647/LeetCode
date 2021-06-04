/**
 *  Recursion: 當作練習遞迴, Linked List的題目不建議用遞迴解
 *             因為會造成stack有O(n)個stack frame, 容易造成
 *             stack overflow.
 *
 *  Time complexity: O(n)
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
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head; // if this node equals to next node, skip this node
    }
}