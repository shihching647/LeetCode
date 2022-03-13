/**
 *
 * Time complexity: next() -> O(1), hasNext() -> O(1)
 * Space complexity: O(N)
 *
 */
// 
class BSTIterator {
    
    private List<Integer> list;
    private int current;

    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        inorder(root);
    }
    
    private void inorder(TreeNode x) {
        if (x == null) return;
        inorder(x.left);
        list.add(x.val);
        inorder(x.right);
        return;
    }
    
    public int next() {
        return list.get(current++);
    }
    
    public boolean hasNext() {
        return current < list.size();
    }
}