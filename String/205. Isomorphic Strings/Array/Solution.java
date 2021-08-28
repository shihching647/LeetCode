/**
 * 兩個array, 一個紀錄c1 -> c2的mapping, 另一個紀錄c2是否有被mapping過(因為題目要求不能重複mapping)
 * Time complexity: O(n)
 * Space complexity: O(R) (R = 256)
 *
 */
class Solution {
    
    public static final int R = 256;
    
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] map = new int[R]; // 用來記錄c1 -> c2的表格
        boolean[] isShown = new boolean[R]; // 用來記錄c2是否已經被mapping過
        
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (map[c1] == 0) { // c1沒應對應的c2
                if (isShown[c2]) // 且c2沒被mapping過
                    return false;
                map[c1] = c2;
                isShown[c2] = true;
            }
            // 檢查mapping是否滿足
            if (map[c1] != c2) {
                return false;
            }
        }
        return true;
    }
}