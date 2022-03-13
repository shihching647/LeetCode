/**
 * StringBuilder
 *
 * Time complexity: O(N)
 * Space complexity: O(N)
 *
 */
class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        StringBuilder result = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                sb.append(s.charAt(i));
            } else if (sb.length() != 0) {
                result.append(sb.reverse()).append(' ');
                sb = new StringBuilder();
            }
        }
        if (sb.length() > 0)
            result.append(sb.reverse());
        return result.toString();
    }
}