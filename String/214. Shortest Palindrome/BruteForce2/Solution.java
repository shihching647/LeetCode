/**
 * 此題的重點就是: 找到最長的palindrome prefix的index位置, 將index + 1之後的sub string reverse後, 再往前prepend上去, 即可得到答案.
 * Brute force: 從長度n開始檢查是否為palindrome
 * 
 * Time complexity: O(N ^ 2)
 * Space complexity: O(N)
 *
 */

class Solution {
    public String shortestPalindrome(String s) {
        int n = s.length();
        String reverse = new StringBuilder(s).reverse().toString();
        for (int i = s.length(); i >= 1; i--) { // 這邊的i指的是substring的長度
            if (s.substring(0, i).equals(reverse.substring(n - i, n))) {
                return new StringBuilder(s.substring(i)).reverse().append(s).toString();
            }
        }
        return "";
    }
}