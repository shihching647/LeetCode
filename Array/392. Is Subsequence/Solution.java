/**
 * Iterate t, and check if i == s.length()
 * Time complexity: O(s + t)
 * Space complexity: O(1)
 */

class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) 
            return true;
        int i = 0;
        for (char c : t.toCharArray()) {
            if (s.charAt(i) == c && ++i > s.length() - 1)
                break;
        }
        return i == s.length();
    }
}