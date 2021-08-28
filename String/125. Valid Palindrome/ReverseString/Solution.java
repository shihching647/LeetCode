/**
 * Reverse string
 * Time complexity: O(n)
 * Space complexity: O(n)
 *
 */
class Solution {
    public boolean isPalindrome(String s) {
        String str = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String reverseStr = new StringBuilder(str).reverse().toString();
        return str.equals(reverseStr);
    }
}