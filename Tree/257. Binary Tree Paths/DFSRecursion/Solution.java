/**
 * Recursion version
 * Time complexity: O(N)
 * Space complexity: O(N)
 *
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new LinkedList<>();
        Stack<String> stack = new Stack<>();
        dfs(root, stack, result);
        return result;
    }
    
    private void dfs(TreeNode x, Stack<String> stack, List<String> result) {
        if (x == null)
            return;
        stack.push(String.valueOf(x.val));
        if (x.left == null && x.right == null) {
            result.add(String.join("->", stack));
        } else {
            dfs(x.left, stack, result);
            dfs(x.right, stack, result);
        }
        stack.pop();
        return;
    }
}