/**
 * Tree link manipilation:
 * 從root開始
 * 若x.left不為null, 將原來的x.left變成x的rightChild, 原來的x.right變成的x inorder predecessor的rightChild
 * 若x.left為null, 表示左邊已處理完 x = x.right
 *
 * Time complexity: O(N)
 * Space complexity: O(1)
 *
 */
class Solution {
    public void flatten(TreeNode root) {
        TreeNode x = root;
        while (x != null) {
            if (x.left != null) {
                TreeNode predecessor = x.left;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                TreeNode right = x.right;
                x.right = x.left; // 將原來的x.left變成x的rightChild
                x.left = null;    // x.left設成null
                predecessor.right = right; // 原來的x.right變成的x inorder predecessor的rightChild
                x = x.right;
            } else {
                x = x.right;
            }
        }
    }
}