/**
 * 想法：跟Recursion一樣就是inorder traversal, 只是用Morris traversal(visit()有兩種想法, 都可以)
 * The first element is always larger than its next one 
 * The second element is always smaller than its previous one.
 * 由上面的原則, 可找到需要swap的兩個element
 * 
 *
 * 參考: https://leetcode.com/problems/recover-binary-search-tree/discuss/32559/Detail-Explain-about-How-Morris-Traversal-Finds-two-Incorrect-Pointer
 * Time complexity: O(N)
 * Space complexity: O(1)
 *
 */
class Solution {
    
    TreeNode preElement = null, firstElement = null, secondElement = null;
    
    public void recoverTree(TreeNode root) {
        TreeNode x = root;
        while (x != null) {
            if (x.left == null) {
                visit(x);
                x = x.right;
            } else {
                TreeNode pre = x.left;
                while (pre.right != null && pre.right != x) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = x;
                    x = x.left;
                } else {
                    visit(x);
                    pre.right = null;
                    x = x.right;
                }
            }
        }
        
        // swap
        int temp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = temp;
        return;
    }
    
    private void visit(TreeNode x) {
        // 法一
        // if (firstElement == null && preElement != null && preElement.val > x.val) {
        //     firstElement = preElement;
        // }
        // if (firstElement != null && preElement.val > x.val) {
        //     secondElement = x;
        // }
        // preElement = x;
        
        // 法二
        if(preElement != null && preElement.val > x.val){
            if(firstElement == null){
                firstElement = preElement;
                secondElement = x;
            } else {
                secondElement = x;
            }
        }
        preElement = x;
    }
    
}