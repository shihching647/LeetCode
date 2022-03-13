/**
 * Preorder traversal
 * Time complexity: O(N)
 * Space complexity: O(height(N))
 *
 */
class Solution {
    
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        preorder(root, list);
        return list;
    }
    
    private void preorder(TreeNode x, List<Integer> list) {
        if (x == null)
            return;
        list.add(x.val);
        if (x.left != null)
            preorder(x.left, list);
        if (x.right != null)
            preorder(x.right, list);
    }
    
}