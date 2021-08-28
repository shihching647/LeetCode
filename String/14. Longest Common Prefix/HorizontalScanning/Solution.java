/**
 * 先將第一個當作commonPrefix, 再iterate strs一個一個比較
 * Time complexity: O(S), where S is the sum of all characters in all strings.
 * Space complexity: O(1)
 *
 */
class Solution {
     public String longestCommonPrefix(String[] strs) {
         if (strs.length == 0)
             return "";
         String common = strs[0];
         for (int i = 1; i < strs.length; i++) {
             while (strs[i].indexOf(common) != 0) { // 等於0表示strs[i]與common從index為0處開始相同
                 common = common.substring(0, common.length() - 1);
                 if (common.isEmpty()) return "";
             }
         }
         return common;
    }
}