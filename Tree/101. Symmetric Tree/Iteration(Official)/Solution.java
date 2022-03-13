/**
 * Iteration: Level order
 * 一開始先將root offer兩次, 每次取兩個Node出來比較他們的值, 再依順序將
 * leftNode的left, rightNode的right, leftNode的right, rightNode.left都加到queue去(包含null)
 * 
 * Time complexity: O(N)
 * Space complexity: O(N)
 *
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode leftNode = queue.poll();
            TreeNode rightNode = queue.poll();
            if (leftNode == null && rightNode == null) continue;
            if (leftNode == null || rightNode == null) return false;
            if (leftNode.val != rightNode.val) return false;
            queue.offer(leftNode.left);
            queue.offer(rightNode.right);
            queue.offer(leftNode.right);
            queue.offer(rightNode.left);
        }
        return true;
    }
}