/**
 * Recursive preorder traversal
 *
 * Time complexity: O(N)
 * Space complexity: O(h)
 *
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> wrap = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        preorder(root, targetSum, stack, wrap);
        return wrap;
    }
    
    private void preorder(TreeNode x, int target, Stack<Integer> stack, List<List<Integer>> wrap) {
        if (x == null)
            return;
        
        stack.push(x.val); // push current node to path stack
        int sum = target - x.val;
        // find a path, add the path to wrap list
        if (x.left == null && x.right == null && sum == 0) {
            LinkedList<Integer> list = new LinkedList<>(stack);
            wrap.add(list);
        }
        
        preorder(x.left, sum, stack, wrap);
        preorder(x.right, sum, stack, wrap);
        stack.pop();  // pop current node out 
    }
}