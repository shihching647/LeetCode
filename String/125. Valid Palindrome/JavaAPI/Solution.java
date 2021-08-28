/**
 * Two pointer
 * Time complexity: O(n)
 * Space complexity: O(1)
 *
 */
class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) j--;
            if (Character.toUpperCase(s.charAt(i)) != Character.toUpperCase(s.charAt(j))) 
                return false;
            i++;
            j--;
        }
        return true;
    }
}