/**
 * Use HashMap
 * Time complexity: O(n)
 * Space complexity: O(R)
 *
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        
        if (s.length() != t.length())
            return false;
        
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            int count = map.getOrDefault(c, 0);
            map.put(c, ++count);
        }
        for (char c : t.toCharArray()) {
            Integer count = map.get(c);
            if (count == null) 
                return false;
            count--;
            if (count == 0) {
                map.remove(c);
            } else {
                map.put(c, count);
            }
            
        }
        return map.size() == 0;
    }
}