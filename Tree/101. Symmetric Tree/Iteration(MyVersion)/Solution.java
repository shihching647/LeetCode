/**
 * Iteration: Level order
 *
 * Time complexity: O(N)
 * Space complexity: O(N)
 *
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        Queue<TreeNode> leftQueue = new LinkedList<>();
        Queue<TreeNode> rightQueue = new LinkedList<>();
        if (root.left != null) leftQueue.offer(root.left);
        if (root.right != null) rightQueue.offer(root.right);
        
        while (!leftQueue.isEmpty() && !rightQueue.isEmpty()) {
            for (int i = 0; i < leftQueue.size(); i++) {
                TreeNode leftNode = leftQueue.poll();
                TreeNode rightNode = rightQueue.poll();
                if (leftNode.val != rightNode.val) 
                    return false;
                
                if (leftNode.left != null || rightNode.right != null) {
                    if (leftNode.left != null && rightNode.right != null)  {
                        leftQueue.offer(leftNode.left);
                        rightQueue.offer(rightNode.right);
                    } else return false;
                }
                
                if (leftNode.right != null || rightNode.left != null) {
                    if (leftNode.right != null && rightNode.left != null) {
                        leftQueue.offer(leftNode.right);
                        rightQueue.offer(rightNode.left);
                    } else return false;   
                }
            }
        }
        
        return leftQueue.size() == rightQueue.size();
    }
}