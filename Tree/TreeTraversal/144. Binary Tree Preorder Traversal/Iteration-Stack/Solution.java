/**
 * Preorder traversal
 * Time complexity: O(N)
 * Space complexity: O(height(N))
 *
 */
class Solution {
    
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) 
            new LinkedList<>();
        
        List<Integer> preorder = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            TreeNode x = stack.pop();
            if (x != null) {
                preorder.add(x.val);
                if (x.right != null)
                    stack.push(x.right);
                if (x.left != null)
                    stack.push(x.left);
            }
        }
        
        return preorder;
    }
    
}