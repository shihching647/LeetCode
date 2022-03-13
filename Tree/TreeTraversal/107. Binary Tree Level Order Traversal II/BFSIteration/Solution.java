/**
 * Time complexity: O(N)
 * Space complexity: O(N)
 *
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> wrap = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null)
            q.offer(root);
        while (!q.isEmpty()) {
            List<Integer> list = new LinkedList<>();
            int count = q.size();
            for (int i = 0; i < count; i++) {
                TreeNode x = q.poll();
                list.add(x.val);
                if (x.left != null) q.offer(x.left);
                if (x.right != null) q.offer(x.right);
            }
            wrap.addFirst(list);
        }
        return wrap;
    }
}