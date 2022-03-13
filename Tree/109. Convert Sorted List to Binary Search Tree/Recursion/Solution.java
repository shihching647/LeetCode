/**
 * Recursion:
 *
 * Time complexity: O(NlogN) (每層都是N, 共有logN層)
 * Space complexity: O(logN)
 *
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return buildTree(head, null);
    }
    
    private TreeNode buildTree(ListNode head, ListNode tail) {
        if (head == tail) 
            return null;
        // ListNode sentinel = new ListNode(0, head);
        ListNode slow = head, fast = head;
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode x = new TreeNode(slow.val);
        x.left = buildTree(head, slow);
        x.right = buildTree(slow.next, tail);
        return x;
    }
}