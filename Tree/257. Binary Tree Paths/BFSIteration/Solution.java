/**
 * DFS iteration version
 *
 * Time complexity: O(N)
 * Space complexity: O(N)
 *
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new LinkedList<>();
        Queue<String> pathQueue = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        
        if (root != null) {
            pathQueue.offer("");
            q.offer(root);
        }
        
        while (!pathQueue.isEmpty()) {
            String path = pathQueue.poll();
            TreeNode x = q.poll();
            if (x.left == null && x.right == null) {
                result.add(path + x.val);
            }
            if (x.left != null) {
                pathQueue.offer(path + x.val + "->"); // 因為知道有後面, 所以->加在這
                q.offer(x.left);
            }
            if (x.right != null) {
                pathQueue.offer(path + x.val + "->"); // 因為知道有後面, 所以->加在這
                q.offer(x.right);
            }
        }
        
        return result;
    }
    
}