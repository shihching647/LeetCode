/**
 * Iteration version
 * Time complexity: O(N)
 * Space complexity: O(height(N))
 *
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode x = root;
        while (x != null || !stack.isEmpty()) {
            if (x != null) {
                stack.push(x);
                x = x.left;
            } else {
                x = stack.pop();
                list.add(x.val);
                x = x.right;
            }
        }
        return list;
    }
}