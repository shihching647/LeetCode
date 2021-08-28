/**
 * 使用長度len做binary search, 每次都檢查整個strs[]看長度len的sub-String是否全部一樣
 * true -> 往更長的找 (因為全不一樣, 試試看更長的是否也會一樣)
 * false -> 往更短的找 (因為太長, 試試看更短的是否一樣)
 * 
 * Worst case: n個長度為m的字串
 * 
 * Time complexity: O(Slogm), where S is the sum of all characters in all strings. (不會分析)
 * 
 * Space complexity: O(1)
 *
 */

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        
        // 先找到最短字串的長度minLen
        int minLen = Integer.MAX_VALUE;
        for (String str : strs)
            minLen = Math.min(str.length(), minLen);
        
        // 在使用len做binary search找到common prefix的長度
        int lo = 1;
        int hi = minLen;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (isCommonPrefix(strs, mid)) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        
        return strs[0].substring(0, hi); // 回傳common prefix
    }
    
    // 檢查整個strs[]看長度len是否一樣
    private boolean isCommonPrefix(String[] strs, int len) {
        String str1 = strs[0].substring(0, len);
        for (int i = 1; i < strs.length; i++) {
            if (!strs[i].startsWith(str1))
                return false;
        }
        return true;
    }
    
}