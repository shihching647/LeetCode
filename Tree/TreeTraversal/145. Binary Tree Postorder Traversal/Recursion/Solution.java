/**
 * Recursion version
 * Time complexity: O(N)
 * Space complexity: O(height(N))
 *
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        postorder(root, list);
        return list;
    }
    
    private void postorder(TreeNode x, List<Integer> list) {
        if (x == null)
            return;
        if (x.left != null)
            postorder(x.left, list);
        if (x.right != null)
            postorder(x.right, list);
        list.add(x.val);
    }
}