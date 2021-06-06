/**
 * 先用一個map存有match的index, key : index, value : 位置pos (一開始是存String[]{sources[i], targets[i]}不需要這模麻煩,存i就好)
 * 在輪詢s, 遇到有match就用目標字串取代, i前進原字串長
 *  
 * Time complexity: O(n + s)
 * Space complexity: O(n)
 */

class Solution {
    public String findReplaceString(String s, int[] indexes, String[] sources, String[] targets) {
        HashMap <Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < indexes.length; i++) {
            int index = indexes[i];
            String source = sources[i];
            // if (index + source.length() <= s.length() && s.substring(index, index + source.length()).equals(source)) {
            if (s.startsWith(source, index)) { // 用startsWith較好, 這樣就可不必判斷index + source.length() <= s.length()
                map.put(index, i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length();) {
            Integer pos = map.get(i);
            if (pos != null) {
                sb.append(targets[pos]);
                i += sources[pos].length();
            } else {
                sb.append(s.charAt(i));
                i++;
            }
        }
        return sb.toString();
    }
}