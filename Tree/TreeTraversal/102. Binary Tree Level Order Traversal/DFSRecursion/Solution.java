/**
 * DFS recursion (or like preorder traversal)
 * Time complexity: O(N)
 * Space complexity: O(N)
 *
 */
class Solution {
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> wrap = new ArrayList<>();
        levelOrder(root, wrap, 0);
        return wrap;
    }
    
    private void levelOrder(TreeNode x, List<List<Integer>> wrap, int level) {
        if (x == null) 
            return;
        if (wrap.size() < level + 1)
            wrap.add(new LinkedList<>());
        wrap.get(level).add(x.val);
        levelOrder(x.left, wrap, level + 1);
        levelOrder(x.right, wrap, level + 1);
    }
}