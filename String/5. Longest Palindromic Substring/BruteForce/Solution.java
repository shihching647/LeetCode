/**
 * Brute force: 找每個index i的最長palindrome(l從最長開始)
 * 
 * Time complexity: O(N ^ 3)
 * Space complexity: O(1)
 *
 */

class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 1)
            return s;
        String ans = "";
        for (int i = 0; i < n; i++) {
            for (int l = n - i; l >= 1; l--) {
                if (isPalindrome(s, i, l)) {
                    if (l > ans.length()) {
                        ans = s.substring(i, i + l);
                    }
                    break;
                }
            }
        }
        return ans;
    }
    
    private boolean isPalindrome(String s, int start, int len) {
        int l = start, r = start + len - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
}