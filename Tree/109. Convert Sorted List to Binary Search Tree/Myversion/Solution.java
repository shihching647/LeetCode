/**
 * Recursion:
 * 將singly-linked list轉成,Java的ArrayList, 就可將問題變成P.108

 * Time complexity: O(N)
 * Space complexity: O(N)
 *
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        return buildTree(list, 0, list.size() - 1);
    }
    
    private TreeNode buildTree(List<ListNode> list, int left, int right) {
        if (left > right)
            return null;
        int mid = left + (right - left) / 2;
        TreeNode x = new TreeNode(list.get(mid).val);
        x.left = buildTree(list, left, mid - 1);
        x.right = buildTree(list, mid + 1, right);
        return x;
    }
}