/**
 * Iterative inorder traversal
 *
 * Time complexity: O(N)
 * Space complexity: O(k)
 *
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode x = root;
        while (!stack.isEmpty() || x != null) {
            if (x != null) {
                stack.push(x);
                x = x.left;
            } else {
                x = stack.pop();
                // visit node
                if (--k == 0) return x.val;
                x = x.right;
            }
        }
        throw new IllegalArgumentException();
    }
}