/**
 * Recursion + Memoization(使用hash map, s1*s2當作key) + pruning(如果有s1, s2含的字母不一樣, 則不可能是scramble):
 * 
 * 參考: https://www.youtube.com/watch?v=MDmZm_aVDF8&ab_channel=TECHDOSE
 * 
 * Time Complexity: O(N ^ 3)
 * Space Complexity: O(N ^ 2)
 * 
 **/
class Solution {
    public boolean isScramble(String s1, String s2) {
        return isScramble(s1, s2, new HashMap<>());
    }
    
    private boolean isScramble(String s1, String s2, HashMap<String, Boolean> memo) {
        String key = s1 + "*" + s2;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        
        if (s1.length() == 1) {
            return s1.equals(s2);
        }
        if (s1.equals(s2)) {
            return true;
        }
        
        boolean result = false;
        int n = s1.length();
        // pruning: 如果有s1, s2含的字母不一樣, 則不可能是scramble
        boolean hasDifferent = hasDifferentChar(s1, s2);
        if (hasDifferent) {
            memo.put(key, result);
            return result;
        }
        for (int i = 1; i < n; i++) {
             result = isScramble(s1.substring(0, i), s2.substring(0, i), memo) && isScramble(s1.substring(i, n), s2.substring(i, n), memo)
                      || isScramble(s1.substring(0, i), s2.substring(n - i, n), memo) && isScramble(s1.substring(i, n), s2.substring(0, n - i), memo);
            if (result) {
                break;
            }
        }
        memo.put(key, result);
        return result;
    }
    
    private boolean hasDifferentChar(String s1, String s2) {
        int[] count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0)
                return true;
        }
        return false;
    }
}