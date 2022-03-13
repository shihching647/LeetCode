/**
 * Level order:
 *
 * Time complexity: O(N)
 * Space complexity: O(N)
 *
 */
class Solution {
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root != null)
            queue.offer(root);
    
        while (!queue.isEmpty()) {
            int n = queue.size();
            Node pre = null;
            for (int i = 0; i < n; i++) {
                Node x = queue.poll();
                if (x.left != null) queue.offer(x.left);
                if (x.right != null) queue.offer(x.right);
                if (pre != null)
                    pre.next = x;
                pre = x;
            }
        }
        
        return root;
    }
}