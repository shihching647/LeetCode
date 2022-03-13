/**
 * DFS iteration version
 * 基本上與BFS一模一樣, 只是把Queue換成Stack
 *
 * Time complexity: O(N)
 * Space complexity: O(N)
 *
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new LinkedList<>();
        Stack<String> pathStack = new Stack<>();
        Stack<TreeNode> s = new Stack<>();
        if (root != null) {
            pathStack.push("");
            s.push(root);
        }
        while (!s.isEmpty()) {
            String path = pathStack.pop();
            TreeNode x = s.pop();
            if (x.left == null && x.right == null) {
                result.add(path + x.val);
            }
            if (x.left != null) {
                pathStack.push(path + x.val + "->");
                s.push(x.left);
            }
            if (x.right != null) {
                pathStack.push(path + x.val + "->");
                s.push(x.right);
            }
        }
        
        return result;
    }
}