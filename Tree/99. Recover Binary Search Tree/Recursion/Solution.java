/**
 * 想法：
 * The first element is always larger than its next one 
 * The second element is always smaller than its previous one.
 * 由上面的原則, 可找到需要swap的兩個element
 * 
 * Time complexity: O(N)
 * Space complexity: O(logN)
 *
 */
class Solution {
    TreeNode firstElement = null;
    TreeNode secondElement = null;
    TreeNode preElement = null;
    
    public void recoverTree(TreeNode root) {
        inorder(root);
        // swap
        int temp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = temp;
        return;
    }
    
    private void inorder(TreeNode x) {
        if (x == null)
            return;
        inorder(x.left);
        
        // visit node
        if (firstElement == null && preElement != null && preElement.val > x.val) {
            firstElement = firstElement != null;
        }
        if (firstElement != null && preElement.val > x.val) { // 這裡不需要加preElement != null, 因為當firstElement != null時候, 就保證了preElement不會是null
            secondElement = x; 
        }
        preElement = x;
        
        inorder(x.right);
        return;
    }
    
}