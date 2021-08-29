/**
 * 每次iteration將對應兩者的字母標為同一個數字,
 * 每次都會先檢查兩者的對應是否一樣, 若不一樣回傳false, 若一樣就在重新標注.
 * 
 * Time complexity: O(n)
 * Space complexity: O(R) (R = 256)
 *
 */
class Solution {
    public static final int R = 256;
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;
        
        int[] mapS = new int[R], mapT = new int[R];
        for (int i = 0; i < s.length(); i++) {
            // 先檢查兩個字母的map是否一樣(若其中一個之前有出現過, 這邊就會retturn false)
            if (mapS[s.charAt(i)] != mapT[t.charAt(i)])
                return false;
            // 兩個字母標註為一樣的數字
            mapS[s.charAt(i)] = i + 1;
            mapT[t.charAt(i)] = i + 1;
        }
        return true;
    }
}