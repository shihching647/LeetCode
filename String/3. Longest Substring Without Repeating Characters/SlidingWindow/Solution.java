/**
 * 使用i, j控制window大小
 * 每次都移動j, 移動j時檢查該元素是否已經出現過, 
 * 若出現過 && i目位置 < 最後一次出現位置 + 1 --> i移動到該字母最後一次出現位置 + 1
 * (也可用i = Math.max(i, map[c] + 1)取代)
 * 
 * Time complexity: O(N ^ 2)
 * Space complexity: O(128)
 *
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0, i = 0, j = 0;
        int[] map = new int[128]; // 紀錄每個字母最後一次出現的位置
        Arrays.fill(map, -1);
        
        for (j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            // i = Math.max(i, map[c] + 1); 下面那段可用此行代替
            if (map[c] != -1 && i < map[c] + 1) { // 該字母前面出現過 && i比該位置還要前面 (代表i到該位置都不能用, i要移動到map[c] + 1, 若i已超過map[c] + 1就不用理他)
                i = map[c] + 1;
            }
            
            max = Math.max(max, j - i + 1);
            map[c] = j;
        }
        return max;
    }
}