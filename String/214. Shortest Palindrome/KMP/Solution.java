/**
 * 此題的重點就是: 找到最長的palindrome prefix的index位置, 將index + 1之後的sub string reverse後, 再往前prepend上去, 即可得到答案.
 * 使用KMP的pattetn的table來取得.
 * (KMP table[i]的定義就是, pattern[0, i]相等且最長的sufix和prefix.
 *  若將字串用 s + "#" + reverse, table的最後一項就是s, reverse最長想等index位置)
 *
 * KMP取得table: https://www.youtube.com/watch?v=BXCEFAzhxGY&ab_channel=BackToBackSWE
 * Time complexity: O(N)
 * Space complexity: O(N)
 *
 */

class Solution {
    public String shortestPalindrome(String s) {
        String str = s + "#" + new StringBuilder(s).reverse().toString();
        int[] table = computeKMPTable(str);
        int pos = table[table.length - 1];
        return new StringBuilder(s.substring(pos)).reverse().append(s).toString();
    }
    
    private int[] computeKMPTable(String pattern) {
        int n = pattern.length();
        int[] table = new int[n];
        int index = 0;
        for (int i = 1; i < pattern.length();) {
            if (pattern.charAt(i) == pattern.charAt(index)) {
                table[i] = ++index;
                i++;
            } else {
                if (index > 0) {
                    index = table[index - 1];
                } else {
                    i++;
                }
            }
        }
        return table;
    }
}