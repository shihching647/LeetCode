/**
 * Recursive inorder traversal
 *
 * Time complexity: O(N)
 * Space complexity: O(H)
 *
 */
class Solution {

    private TreeNode ans;
    private int count;
    
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return ans.val;
    }
    
    private void inorder(TreeNode x, int k) {
        if (x == null && ans != null)
            return;
        
        if (ans == null && x.left != null) 
            inorder(x.left, k);
        
        if (ans == null && ++count == k) {
            ans = x;
            return;
        }
        
        if (ans == null && x.right != null) 
            inorder(x.right, k);
    }
}