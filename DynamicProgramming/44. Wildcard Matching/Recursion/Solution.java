/**
 * Recursion(TLE) (參考LeetCode10. Regular Expression Matching)
 * 先看第一個字元有沒有滿足
 * 檢查第一個字母是否為'*'
 * 若為* => 兩種情況都要explore下去, 1.要使用* 2.不使用*
 * 若不為* => 直接移到下一個檢查是否一樣
 * 
 * Time complexity: O(???)
 * Space complexity: O(???)
 */
class Solution {
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        
        boolean isFirstCharMatch = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '?');
        if (p.charAt(0) == '*') {
            return !s.isEmpty() && isMatch(s.substring(1), p) || isMatch(s, p.substring(1));
        } else {
            return isFirstCharMatch && isMatch(s.substring(1), p.substring(1));
        }
    }
}