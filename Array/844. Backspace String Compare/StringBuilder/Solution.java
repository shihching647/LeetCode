/**
 * StringBuilder組string, 在比較兩者是否一樣
 *
 * Time complexity: O(m + n) (m = s.length(), n = t.length())
 * Space complexity: O(m + n) (m = s.length(), n = t.length())
 */
class Solution {
    public boolean backspaceCompare(String s, String t) {
        return buildString(s).equals(buildString(t));
    }

    private String buildString(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '#') {
                if (sb.length() != 0)
                    sb.deleteCharAt(sb.length() - 1); // deleteCharAt(index)刪除 index的字元,
            } else
                sb.append(c);
        }
        return sb.toString();
    }
}