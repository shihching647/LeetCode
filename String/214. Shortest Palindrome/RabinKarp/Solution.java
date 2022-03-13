/**
 * 此題的重點就是: 找到最長的palindrome prefix的index位置, 將index + 1之後的sub string reverse後, 再往前prepend上去, 即可得到答案.
 * Rabin Karp algorithm:
 * 將s跟reverse, 從第一個字母開始檢查是否為palindrome, 一直到最後一位
 * 檢查字串相等的方式是用Karp Rabin rolling hash的方式.
 *
 * Time complexity: O(N ^ 2) (average: O(N), worse case: "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
 * Space complexity: O(N)
 *
 */

class Solution {
    public String shortestPalindrome(String s) {
        int n = s.length();
        int pos = -1;  // 紀錄palindrome發生的位置
        int base = 26; // 計算hash value的base
        int r = 1;     // 用來計算reverse的hash value
        int q = 997;   // prime number
        int hash1 = 0, hash2 = 0;
        String reverse = new StringBuilder(s).reverse().toString();
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a' + 1;
            hash1 = (hash1 * base + c) % q; // s的hash value
            hash2 = (hash2 + c * r) % q;    // reverse的hash value
            if (hash1 == hash2) {
                // Las Vegas version(再次確認是否相等, 避免false collision)
                String subStr = s.substring(0, i + 1);
                String subReverse = reverse.substring(n - i - 1);
                if (subStr.equals(subReverse)) {
                   pos = i;
                }
            }
            r = (r * base) % q; // 下一輪算reverse的hash value用
        }
        return new StringBuilder(s.substring(pos + 1)).reverse().append(s).toString(); 
    }
}