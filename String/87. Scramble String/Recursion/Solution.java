/**
 * Recursion:
 * 
 * 參考: https://www.youtube.com/watch?v=MDmZm_aVDF8&ab_channel=TECHDOSE
 * 
 * Time Complexity: O(???)
 * Space Complexity: O(???)
 * 
 **/
class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.length() == 1) {
            return s1.equals(s2);
        }
        if (s1.equals(s2)) {
            return true;
        }
        int n = s1.length();
        for (int i = 1; i < n; i++) {
            // 兩種case: 1.不交換, 2.交換
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i, n), s2.substring(i, n))
                || isScramble(s1.substring(0, i), s2.substring(n - i, n)) && isScramble(s1.substring(i, n), s2.substring(0, n - i)))
                return true;
        }
        return false;
    }
}