/**
 * 嘗試每個i(長度為奇數palindrome), 與i跟i中間當作palindrome的中心(長度為偶數palindrome). 找到最長的palindrome
 * 
 * Time complexity: O(N ^ 2)
 * Space complexity: O(1)
 *
 */

class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 1)
            return s;
        String result = "";
        for (int i = 0; i < n; i++) {
            int len1 = expandAroundCenter(s, i, i); // 長度為奇數palindrome
            int len2 = expandAroundCenter(s, i, i + 1);// 長度為偶數palindrome
            int len = Math.max(len1, len2);
            if (len > result.length()) {
                int start = i - (len - 1) / 2;
                int end = i + (len) / 2;
                result = s.substring(start, end + 1);
            }
        }
        return result;
    }
    
    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right))
                break;
            left--;
            right++;
        }
        return right - left - 1;
    }
}