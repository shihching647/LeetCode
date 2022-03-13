/**
 * traverse original tree in {right, left, root} order (與postorder = {left, right, root}不同)
 * 此種traverse方法, 與flaaten後的tree postorder一樣
 *
 * Time complexity: O(N)
 * Space complexity: O(h)
 *
 */
// 
class Solution {
    public void flatten(TreeNode root) {
        flatten(root, null);
    }

    private TreeNode flatten(TreeNode x, TreeNode pre) {
        //{right, left, root} order
        if (x == null) 
            return pre;
        pre = flatten(x.right, pre);
        pre = flatten(x.left, pre);
        
        // 將x.right與pre接起來
        x.right = pre;
        x.left = null;
        return x; // 回傳x
    }
}