/**
 * 使用divide and conquer, 將大問題拆成小問題
 * 原始問題: LCP(S1, S2, ..., Sn) -> LCP(LCP(S1, S2,..., Smid, LCP(Smid, Smid+1, ...., Sn))
 * 一路拆到剩一個可直接為傳該字串, 再將兩兩合併
 * 
 * Worst case: n個長度為m的字串
 * 
 * Time complexity: O(S), where S is the sum of all characters in all strings. (不會分析)
 * 
 * Space complexity: O(m * logn)
 *
 */

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        return longestCommonPrefix(strs, 0, strs.length - 1);
    }
    
    private String longestCommonPrefix(String[] strs, int l, int r) {
        if (l == r) 
            return strs[l];
        
        int mid = (l + r) / 2;
        String leftStr = longestCommonPrefix(strs, l, mid);
        String rightStr = longestCommonPrefix(strs, mid + 1, r);
        return commonPrefix(leftStr, rightStr);
    }
    
    private String commonPrefix(String left, String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
           if (left.charAt(i) != right.charAt(i)) 
               return left.substring(0, i);
        }
        return left.substring(0, min);
    }
}