/**
 * Iteration:
 * 重root開始往下連結,
 * cur從每一層最左邊的node開始
 * 每次visit cur就先連結x.left與x.right
 * 再連結x.right與x.next.left.
 *  
 * Time complexity: O(N)
 * Space complexity: O(1)
 *
 */
class Solution {
    public Node connect(Node root) {
        Node cur = root;
        while (cur != null && cur.left != null) {
            Node x = cur;
            while (x != null) {
                x.left.next = x.right;
                x.right.next = (x.next == null ? null : x.next.left);
                x = x.next;
            }
            cur = cur.left;
        }
        return root;
    }
}