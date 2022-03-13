/**
 * Iteration: BFS
 * 
 * Time complexity: O(N)
 * Space complexity: O(N)
 *
 */
class Solution {
    public int minDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null)
            queue.offer(root);
        
        int h = 0;
        while (!queue.isEmpty()) {
            int n = queue.size();
            h++;
            for (int i = 0; i < n; i++) {
                TreeNode x = queue.poll();
                if (x.left == null && x.right == null)
                    return h;
                if (x.left != null)
                    queue.offer(x.left);
                if (x.right != null)
                    queue.offer(x.right);
            }
        }
        return h;
    }
}