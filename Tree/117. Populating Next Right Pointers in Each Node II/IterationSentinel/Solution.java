/**
 * Iteration:
 * 某一層使用sentinel連到第一個
 * 這樣就不需要像我寫的版本依樣需要存pre, nextLevel的變數了
 *  
 * Time complexity: O(N)
 * Space complexity: O(1)
 *
 */
class Solution {
    public Node connect(Node root) {
        Node sentinel = new Node(0); // 只用一個sentinel
        Node cur = root;
        while (cur != null) {
            Node x = sentinel;
            while (cur != null) {
                if (cur.left != null) {
                    x.next = cur.left;
                    x = x.next;
                }
                if (cur.right != null) {
                    x.next = cur.right;
                    x = x.next;
                }
                cur = cur.next;
            }
            cur = sentinel.next;
            sentinel.next = null; // 設sentinel.next = null, 然後下一層繼續用同一個sentinel
        }
        return root;
    }
}