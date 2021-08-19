/**
 * 用到的是對BST而言, inorder traverse會由小到大排列
 * 先用inorder traverse 一個整個tree, 並用TreeSet裝所有元素
 * 再inorder traverse第二次, 照TreeSet的順序填入node的值
 * 
 * 
 * Time complexity: O(NlonN) (TreeSet加入/移除N個元素)
 * Space complexity: O(N)
 *
 */
class Solution {

    public void recoverTree(TreeNode root) {
        TreeSet<Integer> set = new TreeSet<>();
        inorder(root, set, false);
        inorder(root, set, true);
        return;
    }
    
    private void inorder(TreeNode x, TreeSet<Integer> set, boolean isSwap) {
        if (x == null)
            return;
        inorder(x.left, set, isSwap);
        if (!isSwap) {
            set.add(x.val);
        } else {
            int correct = set.pollFirst();
            if (correct != x.val) {
                x.val = correct;
            }
        }
        inorder(x.right, set, isSwap);
        return;
    }
}