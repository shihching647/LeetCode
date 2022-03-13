/**
 * 此題的重點就是: 找到最長的palindrome prefix的index位置, 將index + 1之後的sub string reverse後, 再往前prepend上去, 即可得到答案.
 * Brute force: 從最後一個字母開始刪除, 檢查是否為palindrome.
 * 
 * Time complexity: O(N ^ 2)
 * Space complexity: O(1)
 *
 */

class Solution {
    public String shortestPalindrome(String s) {
        for (int i = s.length() - 1; i >= 0; i--) {
            if (isPalindrome(s, 0, i)) {
                return new StringBuilder(s.substring(i + 1)).reverse().append(s).toString();
            }
        }
        return "";
    }
    
    private boolean isPalindrome(String s, int left, int right) {
        if (s.length() == 1)
            return true;
        while(left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
    
}