/**
 * 每個node檢查是否為PBT, 如果是回傳2 ^ (depth + 1) - 1個node, 若不是遞迴呼叫left, right
 * 參考: https://www.youtube.com/watch?v=CvrPf1-flAA&ab_channel=TECHDOSE
 
 * Time complexity: O((logN) ^ 2)
 * Space complexity: O(log(N))
 *
 */
class Solution {
    
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        
        int depth = 0;
        TreeNode leftChild = root, rightChild = root;
        while (leftChild.left != null && rightChild.right != null) {
            depth++;
            leftChild = leftChild.left;
            rightChild = rightChild.right;
        }
        
        // if it's PBT(Prefect Balanced Tree), return 2 ^ (depth + 1) - 1個node
        if (leftChild == null && rightChild == null) {
            return (1 << (depth + 1)) - 1;
        }
        
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    
}