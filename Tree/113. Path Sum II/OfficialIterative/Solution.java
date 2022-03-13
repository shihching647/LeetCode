/**
 * Iteratvie (看不是很懂)
 
 * 大概概念就是 先go left到底, 然後用path和stack追蹤路過的node, 並用pathSum追蹤目前的總和
 * 到底後檢查x.right可不可以走, 可以走就走, 不行走就檢查是否找到path
 * 然後再把path, stack最上面的pop()出來並pathSum更新
 *
 * Time complexity: O(N)
 * Space complexity: O(h)
 *
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> wrap = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        int pathSum = 0;
        Stack<Integer> path = new Stack<>();
        TreeNode pre = null, x = root;
        
        while (x != null || !stack.isEmpty()) {
            // go left until left node is null
            while (x != null) {
                stack.push(x);
                path.push(x.val);
                pathSum += x.val;
                x = x.left;
            }
            
            x = stack.peek();
            if (x.right != null && x.right != pre) { // x.right != pre代表 x的right child還沒檢查過
                x = x.right;
                continue;
            }
            
            if (x.left == null && x.right == null && pathSum == sum) {
                wrap.add(new LinkedList<>(path));
            }
            
            stack.pop();
            pre = x;
            pathSum -= x.val;
            path.pop();
            x = null;
        }
        
        return wrap;
    }
}