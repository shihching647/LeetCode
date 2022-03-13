/**
 * Recursion: 同106解釋
 *
 * Time complexity: O(N)
 * Space complexity: O(N)
 *
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++)
            map.put(inorder[i], i);
        return build(preorder, 0, n - 1, inorder, 0, n - 1, map);
    }
    
    private TreeNode build(int[] preorder, int ps, int pe, int[] inorder, int is, int ie, Map<Integer, Integer> map) {
        if (ps > pe || is > ie)
            return null;
        
        TreeNode x = new TreeNode(preorder[ps]);
        int ri = map.get(preorder[ps]);
        int lenLeft = ri - 1 - is;
        int lenRight= ie - ri - 1;
        
        x.left = build(preorder, ps + 1, ps + 1 + lenLeft, inorder, is, ri - 1, map);
        x.right = build(preorder, pe - lenRight, pe, inorder, ri + 1, ie, map);
        return x;
    }
}