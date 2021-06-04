/**
 * Use class variable and recursion
 * Time complexity: O(n)
 * Space complexoty: O(n)
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
    
    ListNode ref;
    
    public boolean isPalindrome(ListNode head) {
        ref = head;
        return checkPalindrome(head);
    }
    
    public boolean checkPalindrome(ListNode node) {
        if (node == null) return true;
        boolean result = checkPalindrome(node.next);
        boolean isEqual = (ref.val == node.val);
        ref = ref.next;
        return result && isEqual;
    }
    
}