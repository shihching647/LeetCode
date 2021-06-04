/**
 *
 * Using a hash set store the elements have existed
 * Time complexity: O(n)
 * Space complexity: O(n)
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
        HashSet<ListNode> set = new HashSet<>();
        ListNode p = head;
        while (p != null) {
            if (set.contains(p))
                return p;
            set.add(p);
            p = p.next;
        }
        return null;
    }
}