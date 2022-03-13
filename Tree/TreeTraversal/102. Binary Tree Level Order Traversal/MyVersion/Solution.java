/**
 * Time complexity: O(N)
 * Space complexity: O(N)
 *
 */
class Solution {
    
    private static class LevelNode extends TreeNode {
        int level;
        LevelNode(TreeNode node, int level) {
            super(node.val, node.left, node.right);
            this.level = level;
        }
        
    }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        LinkedList<LevelNode> q = new LinkedList<>();
        if (root != null)
            q.addLast(new LevelNode(root, 0));
        while (!q.isEmpty()) {
            LevelNode x = q.removeFirst();
            int level = x.level;
            if (list.size() < level + 1) {
                list.add(new LinkedList<>());
            }
            list.get(level).add(x.val);
            if (x.left != null) q.addLast(new LevelNode(x.left, level + 1));
            if (x.right != null) q.addLast(new LevelNode(x.right, level + 1));
        }
        return list;
    }
}