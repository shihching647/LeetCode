/**
 * Recursion:
 * visit x時先連結x與next
 * 再recursive連結x.left與x.right
 * 回到x時, 再recursive連結x.right與x.next.left
 *  
 * Time complexity: O(N)
 * Space complexity: O(N)
 *
 */
class Solution {
    public Node connect(Node root) {
        connect(root, null);
        return root; 
    }
    
    private void connect(Node x, Node next) {
        if (x == null)
            return;
        x.next = next;
        connect(x.left, x.right);
        connect(x.right, x.next == null ? null : x.next.left);
        return;
    }
}