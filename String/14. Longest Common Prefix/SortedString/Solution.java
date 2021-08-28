/**
 * 先sort strs[], 再比較第一個與最後一個字串, 相等的部分及為common prefix
 * 
 * 
 * Time complexity: O(nlogn * m) (m為strs[]的平均長度)
 *
 * Space complexity: O(1)
 *
 */

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        
        Arrays.sort(strs);
        
        String first = strs[0];
        String last = strs[strs.length - 1];
        
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != last.charAt(i))
                return first.substring(0, i);
        }
        return first;
    }
}