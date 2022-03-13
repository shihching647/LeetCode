/**
 * Recursion + DP(Top Down)
 * 將wordDict內的字所有可能都組起來.
 * 終止條件: sb.length() > s.length()
 * 剪枝: 每次都先檢查sb內的字母是否都跟s一樣, 一但不一樣直接回傳false
 * 
 * 參考: https://leetcode.wang/leetcode-139-Word-Break.html(法1)
 * Time complexity: O(???)
 * Space complexity: O(???)
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashMap<String, Boolean> dp = new HashMap<>();
        return wordBreak(new StringBuilder(), s, wordDict, dp);
    }
    
    private boolean wordBreak(StringBuilder sb, String s, List<String> dict, HashMap<String, Boolean> dp) {
        String temp = sb.toString();
        if (temp.length() > 0 && dp.containsKey(temp)) {
            return dp.get(temp);
        }
        if (sb.length() > s.length()) {
            return false;
        }
        // purning, check every charcters in sb, s are same
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != s.charAt(i))
                return false;
        }
        if (sb.length() == s.length()) {
            return true;
        }
        boolean result = false;
        for (String word : dict) {
            result = wordBreak(sb.append(word), s, dict, dp);
            sb.delete(sb.length() - word.length(), sb.length());
            if (result) {
                return true;
            }
        }
        dp.put(sb.toString(), result);
        return false;
    }
}