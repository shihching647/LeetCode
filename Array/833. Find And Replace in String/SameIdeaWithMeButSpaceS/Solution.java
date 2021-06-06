/**
 * 與我的版本概念相同，但space是O(s), 我的則是O(n)
 * 
 * 先輪詢indexes, 把有match的index記錄在matchIndex裡面
 * (matchIndex[i]為, s有match source的話, matchIndex[i]為sources的位置 + 1, 因為0要給沒有match的用)
 *  
 * 再輪詢s, 檢查matchIndex[i]是否有match, 有的話把targets[pos] append上去, i += sources[i].length()長度
 * Time complexity: O(n + s)
 * Space complexity: O(s)
 */
class Solution {
    public String findReplaceString(String s, int[] indexes, String[] sources, String[] targets) {
        int[] matchIndex = new int[s.length()];
        for (int i = 0; i < indexes.length; i++) {
            if (s.startsWith(sources[i], indexes[i])) {
                matchIndex[indexes[i]] = i + 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length();) {
            int pos = matchIndex[i] - 1;
            if (pos == -1) { // 沒match
                sb.append(s.charAt(i));
                i++;
            } else { // 有match
                sb.append(targets[pos]);
                i += sources[pos].length();
            }
        }
        return sb.toString();
    }
}