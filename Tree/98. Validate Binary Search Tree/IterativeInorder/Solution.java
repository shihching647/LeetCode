/**
 * Iterative inorder: inorder traversal會由小到大照順序排
 *
 * Time complexity: O(N)
 * Space complexity: O(h)
 *
 */
class Solution {
    
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode x = root;
        Integer pre = null;
        while (x != null || !stack.isEmpty()) {
            while (x != null) {
                stack.push(x);
                x = x.left;
            }
            x = stack.pop();
            if (pre != null && pre >= x.val) return false;
            else pre = x.val;
            x = x.right;
        }
        return true;
    }
}