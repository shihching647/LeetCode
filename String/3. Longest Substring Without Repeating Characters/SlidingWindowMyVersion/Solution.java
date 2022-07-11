/**
 * 使用i, j控制window大小
 * 每次都移動j, 移動j時檢查該元素是否已經出現過, i移動到j的位置
 * 
 * Time complexity: O(N)
 * Space complexity: O(128)
 *
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0, i = 0, j = 0;
        int[] map = new int[128];
        Arrays.fill(map, -1);
        
        for (j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            if (map[c] == -1) {
                map[c] = j;
            } else {
                // i移動到j的位置, 並把map清除
                while (i < map[c] + 1) {
                    map[s.charAt(i++)] = -1;   
                }
                map[c] = j;
            }
            max = Math.max(max, j - i + 1);
        }
        return max;
    }
}