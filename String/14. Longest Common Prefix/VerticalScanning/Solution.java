/**
 * 先將第一個當作commonPrefix, 再從common的第i個字母開始對strs[]裡的第一個字母做比較
 * 當發現strs[j]的長度為i時, 或是發現與strs[j]不相同是,就可回傳 common.substring(0, i)
 * 當走到底就表示common整個字串都為commonPrefix

 * Time complexity: O(S), where S is the sum of all characters in all strings. 
 * Worst case: n個長度為m的字串, O(m * n) (與horizontal相同)
 * Best case: O(minLen * n) 
 *
 * Space complexity: O(1)
 *
 */

class Solution {
     public String longestCommonPrefix(String[] strs) {
         if (strs.length == 0)
             return "";
         String common = strs[0];
         for (int i = 0; i < common.length(); i++) {
             char c = common.charAt(i);
             for (int j = 1; j < strs.length; j++) {
                 // 當strs[j]的長度等於i時(就表示common就為strs[j], 就可直接回傳)
                 // 或是 strs[j]的index為i的字母與c不相等, 也是馬上回傳
                 if (i == strs[j].length() || c != strs[j].charAt(i))
                     return common.substring(0, i);
             }
         }
         return common; // 走到這裡表示common整個字串都為commonPrefix
    }
}