/**
 * Recursion version
 * Time complexity: O(N)
 * Space complexity: O(height(N))
 *
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        inorder(root, list);
        return list;
    }
    
    private void inorder(TreeNode x, List<Integer> list) {
        if (x == null)
            return;
        if (x.left != null)
            inorder(x.left, list);
        list.add(x.val);
        if (x.right != null)
            inorder(x.right, list);
        return;
    }
}