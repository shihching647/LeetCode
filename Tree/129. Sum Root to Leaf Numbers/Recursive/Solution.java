/**
 * Recursive: 參考圖示
 *
 * Time complexity: O(N)
 * Space complexity: O(h)
 *
 */
class Solution {
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }
    
    private int sumNumbers(TreeNode x, int sum) {
        if (x == null) {
            return 0;
        }
        // 如果是leaf, 前面的sum * 10 + x.val
        if (x.left == null && x.right == null)
            return sum * 10 + x.val;
        // 否則就是將sum * 10 + x.val帶到x.left, x.right
        return sumNumbers(x.left, sum * 10 + x.val) + sumNumbers(x.right, sum * 10 + x.val);
    }
}