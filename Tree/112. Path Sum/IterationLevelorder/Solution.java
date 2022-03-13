/**
 * Iterative levelorder traversal
 *
 * Time complexity: O(N)
 * Space complexity: O(N)
 *
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> sumStack = new Stack<>();
        if (root != null)
            stack.push(root);
        sumStack.push(targetSum);
        while (!stack.isEmpty()) {
            TreeNode x = stack.pop();
            int sum = sumStack.pop() - x.val;
            
            if (x.left == null && x.right == null && sum == 0)
                return true;
            
            if (x.left != null) {
                stack.push(x.left);
                sumStack.push(sum);
            }
            
            if (x.right != null) {
                stack.push(x.right);
                sumStack.push(sum);
            }
            
        }
        return false;
    }
}