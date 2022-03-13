/**
 * 因為next()最多被呼叫n次(tree有n個node), 每個node都被visit過兩次, 所以next() amortized 為O(1)
 * Time complexity: next() -> amortized O(1), hasNext() -> O(1)
 * Space complexity: O(1)
 *
 */
// 
class BSTIterator {
    
    private TreeNode x;

    public BSTIterator(TreeNode root) {
        x = root;
    }
    
    public int next() {
        int result = 0;
        while (x != null) {
            if (x.left == null) {
                result = x.val;
                x = x.right;
                break;
            } else {
                // find inorder predecessor
                TreeNode pre = x.left;
                while (pre.right != null && pre.right != x) {
                    pre = pre.right;
                }
                
                if (pre.right == null) {
                    pre.right = x;
                    x = x.left;
                } else {
                    pre.right = null;
                    result = x.val;
                    x = x.right;
                    break;
                }
            }
        }
        return result;
    }
    
    public boolean hasNext() {
        return x != null;
    }
}