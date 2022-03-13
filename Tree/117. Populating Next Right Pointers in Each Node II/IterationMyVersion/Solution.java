/**
 * Iteration:
 *  
 * Time complexity: O(N)
 * Space complexity: O(1)
 *
 */
class Solution {
    public Node connect(Node root) {
        Node cur = root;
        while (cur != null) {
            Node x = cur, pre = null, nextLevel = null;
            while (x != null) {
                if (x.left != null) {
                    if (nextLevel == null) nextLevel = x.left;
                    if (pre != null) pre.next = x.left;
                    pre = x.left;
                }
                if (x.right != null) {
                    if (nextLevel == null) nextLevel = x.right;
                    if (pre != null) pre.next = x.right;
                    pre = x.right;
                }
                x = x.next;
            }
            cur = nextLevel;
        }
        return root;
    }
}