/**
 * Iterative levelorder traversal
 *
 * Time complexity: O(N)
 * Space complexity: O(N)
 *
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null)
            queue.offer(root);
        
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode x = queue.poll();
                if (i == n - 1) result.add(x.val);
                if (x.left != null) queue.offer(x.left);
                if (x.right != null) queue.offer(x.right);
            }
        }
        
        return result;
    }
}