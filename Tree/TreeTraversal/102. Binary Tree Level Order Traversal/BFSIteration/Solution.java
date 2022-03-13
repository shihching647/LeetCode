/**
 * Time complexity: O(N)
 * Space complexity: O(N)
 *
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> wrap = new ArrayList<>();
        LinkedList<TreeNode> q = new LinkedList<>();
        
        if (root != null)
            q.offer(root);
        
        while (!q.isEmpty()) {
            int levelCount = q.size(); // 此current的node數量
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < levelCount; i++) {
                TreeNode x = q.poll();
                list.add(x.val);
                if (x.left != null) q.offer(x.left);
                if (x.right != null) q.offer(x.right);
            }
            wrap.add(list);
        }
        return wrap;
    }
}