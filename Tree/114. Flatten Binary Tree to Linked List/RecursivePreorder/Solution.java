/**
 * Recursive preorder
 *
 * Time complexity: O(N)
 * Space complexity: O(N)
 *
 */
class Solution {
    public void flatten(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<>();
        preorder(root, list);
        TreeNode pre = null;
        for (TreeNode x : list) {
            x.left = null;
            if (pre != null) pre.right = x;
            pre = x;
        }
    }
    
    private void preorder(TreeNode x, LinkedList<TreeNode> list) {
        if (x == null)
            return;
        list.add(x);
        if (x.left != null) preorder(x.left, list);
        if (x.right != null) preorder(x.right, list);
    }
}