/**
 * Morris traversal
 * 
 * 參考: https://www.youtube.com/watch?v=wGXB9OWhPTg&ab_channel=TusharRoy-CodingMadeSimple
 * 
 * Time complexity: O(N) (找到每個node的predecessor只需經過N - 1個edge, 故總共O(2N))
 * Space complexity: O(N) (不需用到stack的memory, 只需要存答案的list)
 *
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        TreeNode x = root;
        while (x != null) {
            if (x.left == null) {
                list.add(x.val);
                x = x.right;
            } else {
                // find the inorder predecessor
                TreeNode predecessor = x.left;
                while (predecessor.right != x && predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                // case1: 還沒visit current node's left tree, 將predecessor與current node link起來
                if (predecessor.right == null) {
                    // link inorder predecessor's right node to current node x
                    predecessor.right = x;
                    // go left
                    x = x.left;
                } else { // case2: 已經visit current node's left tree, 將predecessor與current node link斷開, 且可以visit current node了
                    predecessor.right = null;
                    list.add(x.val); 
                    x = x.right; // go right
                }
            }
        }
        return list;
    }
}