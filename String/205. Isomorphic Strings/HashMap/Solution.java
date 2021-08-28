/**
 * Use HashMap
 * Time complexity: O(n)
 * Space complexity: O(n)
 *
 */
class Solution {
    
    public boolean isIsomorphic(String s, String t) {
        
        if (s.length() != t.length())
            return false;
        
        HashMap<Character, Character> stMap = new HashMap<>();
        HashMap<Character, Character> tsMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (stMap.get(c1) == null && tsMap.get(c2) == null) {
                stMap.put(c1, c2);
                tsMap.put(c2, c1);
            } else if (stMap.get(c1) == null || tsMap.get(c2) == null)
                return false;
            if (stMap.get(c1) != c2 || tsMap.get(c2) != c1)
                return false;
        }
        return true;
    }
}