/**
 * Iteration: Top-Down建構
 * 定義IndexNode存TreeNode, 與TreeNode的val對應到的index
 * 先從root開始建構, 再重IndexNode的leftIndex, rightIndex可以知道此TreeNode是否有left, right subtree
 * 
 * Time complexity: O(N)
 * Space complexity: O(N)
 *
 */
class Solution {
    
    private static class IndexNode {
        private TreeNode node;
        private int leftIndex, rightIndex;
        
        public IndexNode(TreeNode node, int leftIndex, int rightIndex) {
            this.node = node;
            this.leftIndex = leftIndex;
            this.rightIndex = rightIndex;
        }
    }
    
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        Stack<IndexNode> stack = new Stack<>();
        TreeNode root = new TreeNode();
        stack.push(new IndexNode(root, 0, n - 1));
        
        while (!stack.isEmpty()) {
            IndexNode indexNode = stack.pop();
            int mid = indexNode.leftIndex + (indexNode.rightIndex - indexNode.leftIndex) / 2;
            TreeNode x = indexNode.node;
            x.val = nums[mid];
            
            if (indexNode.leftIndex <= mid - 1) {
                x.left = new TreeNode();
                stack.push(new IndexNode(x.left, indexNode.leftIndex, mid - 1));
            }
            
            if (indexNode.rightIndex >= mid + 1) {
                x.right = new TreeNode();
                stack.push(new IndexNode(x.right, mid + 1, indexNode.rightIndex));
            }
        }
        
        return root;
    }
    
}