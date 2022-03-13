/**
 * Iteration version
 * Time complexity: O(N)
 * Space complexity: O(height(N))
 *
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode x = root;
        while (x != null || !stack.isEmpty()) {
            if (x != null) {
                list.addFirst(x.val);
                stack.push(x);
                x = x.right;
            } else {
                x = stack.pop();
                x = x.left;
            }
        }
        return list;
    }
}