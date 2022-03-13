/**
 * DFS recursion (or like preorder traversal)
 * Time complexity: O(N)
 * Space complexity: O(N)
 *
 */
class Solution {
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<List<Integer>> wrap = new ArrayList<>();
        levelOrderBottom(root, wrap, 0);
        return wrap;
    }
    
    private void levelOrderBottom(TreeNode x, LinkedList<List<Integer>> wrap, int level) {
        if (x == null)
            return;
        if (wrap.size() < level + 1)
            wrap.addFirst(new LinkedList<>());
        wrap.get(wrap.size() - level - 1).add(x.val);
        levelOrderBottom(x.left, wrap, level + 1);
        levelOrderBottom(x.right, wrap, level + 1);
    }
}