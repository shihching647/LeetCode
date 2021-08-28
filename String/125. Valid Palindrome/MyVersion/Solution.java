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
            while (i < j && !isAlphabet(s.charAt(i)) && !isDigit(s.charAt(i))) i++;
            while (i < j && !isAlphabet(s.charAt(j)) && !isDigit(s.charAt(j))) j--;
            int dif = Math.abs(s.charAt(i) - s.charAt(j));
            if (isDigit(s.charAt(i)) && isDigit(s.charAt(j)) && dif == 0) {
                i++;
                j--;
            } else if (isAlphabet(s.charAt(i)) && isAlphabet(s.charAt(j)) && (dif == 0 || dif == 'a' - 'A')){
                i++;
                j--;
            } else if (dif == 0){
                return true;
            } else {
                return false;
            }
        }
        return true;
    }
    
    private boolean isAlphabet(char c) {
        if (c - 'A' >= 0 && c - 'A' < 26 || c - 'a' >= 0 && c - 'a' < 26) return true;
        else return false;
    }
    
    private boolean isDigit(char c) {
        if (c - '0' >= 0 && c - '0' <= 9) return true;
        else return false;
    }
}