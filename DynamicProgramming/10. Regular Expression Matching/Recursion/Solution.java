/**
 * Recursion (參考:https://www.youtube.com/watch?v=HAA8mgxlov8&ab_channel=NeetCode)
 * 先看第一個字元有沒有滿足
 * 檢查第二個字母是否為'*'(因為*前面一定是一個valid的字元(如:a,b,c...或.))
 * 若為* => 兩種情況都要explore下去, 1.要使用*前那個字元(字元符合) 2.不使用字元
 * 若不為* => 直接移到下一個檢查是否一樣
 * 
 * Time complexity: O(???)
 * Space complexity: O(???)
 * Complexity分析:https://leetcode.com/problems/regular-expression-matching/solution/ (看不懂)
 */
class Solution {
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) 
            return s.isEmpty();
        
        boolean isFirstCharMatch = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        if (p.length() >= 2 && p.charAt(1) == '*') {
            // 1. 要用*前面的那一個字元(第一個字元要符合)
            // 2. 不用那個字元
            return isFirstCharMatch && isMatch(s.substring(1), p) || isMatch(s, p.substring(2));
        } else {
            // 若第一個字元符合才需比對下一個字元
            return isFirstCharMatch && isMatch(s.substring(1), p.substring(1));
        }
    }
}