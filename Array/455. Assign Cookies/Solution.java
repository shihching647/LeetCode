/**
 * 先把g, s排序, 在輪詢糖果數量陣列s看多少人可滿足
 * Time complexity: O(nlogn)
 * Space complexity: O(1)
 */

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0; // i是g的index, j是可滿足的總人數
        for (int n : s) {
            if (n >= g[i]) {
                j++;
                if (++i > g.length - 1) break; // i已經到g的最後一個element了
            }
        }
        return j;
    }
}