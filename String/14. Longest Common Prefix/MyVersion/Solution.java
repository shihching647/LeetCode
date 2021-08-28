/**
 * Horizontal scanning
 * Time complexity: O(S), where S is the sum of all characters in all strings.
 * Space complexity: O(1)
 *
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        char[] ans = strs[0].toCharArray();
        int index = ans.length - 1; // common prefix index
        
        for (int i = 1; i < strs.length && index >= 0; i++) {
            String subStr = strs[i];
            // subStr為空字串, 直接回傳空字串(index = -1)
            if (subStr.length() == 0)
                index = -1;
        
            for (int j = 0; j <= index; j++) {
                // 當j超過subStr的索引值範圍時, common prefix即為j
                if (ans[j] == subStr.charAt(j) && j == subStr.length() - 1) {
                    index = j;
                    break;
                } else if (ans[j] != subStr.charAt(j)) {
                    index = j - 1;
                    break;
                }
            }
        }
        
        return index >= 0 ? new String(Arrays.copyOf(ans, index + 1)) : "";
    }
}