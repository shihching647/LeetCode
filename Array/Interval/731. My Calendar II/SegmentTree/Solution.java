/**
 * Segment tree with lazy propogation
 * 
 * Time complexity: O(nlogd) (insert n times) d = 10^9 因為區間是[0~10^9]
 * Space complexity: worse case: O(d), average case: O(nlogd)
 */
class MyCalendarTwo {
    
    private class TreeNode {
        int low;
        int high;
        int val;
        int lazy;
        TreeNode left, right;
        
        public TreeNode(int low, int high) {
            this.low = low;
            this.high = high;
            this.val = val;
            this.lazy = lazy;
        }
    }
    
    private TreeNode root;
    
    public MyCalendarTwo() {
        root = new TreeNode(0, 1000000000);
    }
    
    private int query(int start, int end, TreeNode x) {

        propagateLazy(x);
        
        // total overlap, return x.val
        if (start <= x.low && end >= x.high) {
            return x.val;
        }
        
        //no overlap. return 0
        if (end < x.low || start > x.high) {
            return 0;
        }
        
        return Math.max(query(start, end, x.left), query(start, end, x.right));
    }
    
    private void update(int start, int end, TreeNode x) {
        // total overlap (因為樹一開始還沒建立, 所以在update時,順便建立, 故lazy要從上面開始往下帶)
        if (start <= x.low && end >= x.high) {
            x.lazy += 1;
        }
        
        propagateLazy(x);
        
        // total overlap, return
        if (start <= x.low && end >= x.high) {
            return;
        }
        
        //no overlap. return
        if (end < x.low || start > x.high) {
            return;
        }
        
        // partial overlap
        update(start, end, x.left);
        update(start, end, x.right);
        
        x.val = Math.max(x.left.val, x.right.val);
    }
    
    // 更新lazy
    private void propagateLazy(TreeNode x) {
        x.val += x.lazy;
        if (x.low != x.high) {
            int mid = (x.low + x.high) / 2;
            // 若無left, right則建立
            if (x.left == null) x.left = new TreeNode(x.low, mid);
            if (x.right == null) x.right = new TreeNode(mid + 1, x.high);
            // lazy往下傳
            x.left.lazy += x.lazy;  
            x.right.lazy += x.lazy;
        }
        x.lazy = 0; // lazy傳遞完畢, 歸0
    }
    
    public boolean book(int start, int end) {
        int k = query(start, end - 1, root);
        if (k >= 2) return false;
        
        update(start, end - 1, root);
        return true;
    }
    
}