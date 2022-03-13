/**
 * DFS iteration version
 *
 * Time complexity: O(N)
 * Space complexity: O(N)
 *
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null)
            q.offer(root);
        
        while (!q.isEmpty()) {
            TreeNode x = q.poll();
            TreeNode temp = x.left;
            x.left = x.right;
            x.right = temp;
            if (x.left != null) q.offer(x.left);
            if (x.right != null) q.offer(x.right);
        }
        
        return root;
    }
}