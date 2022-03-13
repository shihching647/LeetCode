/**
 * 因為next()最多被呼叫n次(tree有n個node), 每個node都被visit過兩次, 所以next() amortized 為O(1)
 * Time complexity: next() -> amortized O(1), hasNext() -> O(1)
 * Space complexity: O(h)
 *
 */
// 
class BSTIterator {

    private Stack<TreeNode> stack;
    
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        addAllLeft(root);
    }
    
    public int next() {
        TreeNode x = stack.pop();
        addAllLeft(x.right); // 不一定每次都會執行while的迴圈
        return x.val;
    }
    
    public boolean hasNext() {
        return stack.size() != 0;
    }
    
    private void addAllLeft(TreeNode x) {
        while (x != null) {
            stack.push(x);
            x = x.left;
        }
    }
}