/**
 * Use Arrays.sort()
 * Time complexity: O(NlogN)
 * Space complexity: O(N)
 *
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        return new String(a).equals(new String(b));
    }
}