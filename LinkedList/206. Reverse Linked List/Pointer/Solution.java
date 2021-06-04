/**
 * 用兩個指標變數紀錄位置, 先將當前與後一個位置記起來, 兩個node reverse後, 再將兩個指標往前移一格
 * Time Complexity: O(n)
 * Space Complexity: O(1)
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
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        
        ListNode p1 = null;
        ListNode p2 = head;
        while (p2 != null) {
            ListNode temp1 = p2;
            ListNode temp2 = p2.next;
            p2.next = p1;
            p1 = temp1;
            p2 = temp2;
        }
        return p1;
    }
}