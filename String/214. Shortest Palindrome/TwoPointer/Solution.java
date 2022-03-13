/**
 * 此題的重點就是: 找到最長的palindrome prefix的index位置, 將index + 1之後的sub string reverse後, 再往前prepend上去, 即可得到答案.
 * Two pointer: 詳細過程可參考: https://leetcode.wang/leetcode-214-Shortest-Palindrome.html (解法2)
 * 我們需要兩個pointer, i 和 j.
 * i初始化為0, j初始化為n - 1.
 * 然後依次判斷 s[i] 和 s[j] 是否相同，
 * 相同的話, i 就進行加 1，j 進行減 1。 
 * s[i] 和 s[j] 不同的話，只將 j 進行減 1
 * 
 *
 * Time complexity: O(N ^ 2) (average: O(N)) (worst case: aabababababababababababababa)
 * Space complexity: O(N) (average: O(1))
 *
 */

class Solution {
    public String shortestPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        char[] a = s.toCharArray();
        while (j >= 0) {
            if (a[i] == a[j]) {
                i++;
                j--;
            } else {
                j--;
            }
        }
        if (i == s.length())
            return s;
        
        String rightPart = s.substring(i);
        StringBuilder reverse = new StringBuilder(rightPart).reverse();
        return reverse.append(shortestPalindrome(s.substring(0, i))).append(rightPart).toString();
    }
}