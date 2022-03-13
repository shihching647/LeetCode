/**
 * Recursion + DP(Top Down)
 * dp[i] = s[0..i]是否可以被分割成wordDict內的字串
 * 
 * Time complexity: O(N ^ 2)
 * Space complexity: O(N)
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<>(wordDict);
        Boolean[] dp = new Boolean[s.length() + 1]; // s[0..i]是否可以被分割成wordDict內的字串
        return wordBreak(s, s.length(), dict, dp);
    }
    
    private boolean wordBreak(String s, int len, Set<String> dict, Boolean[] dp) {
        if (len == 0)
            return true;
        if (dp[len] != null)
            return dp[len];
        boolean result = false;
         // 找分割點
        for (int i = 0; i < len; i++) {
            String right = s.substring(i, len); // right用來檢查是否有在字典內
            result = wordBreak(s, i, dict, dp) && dict.contains(right);
            if (result)
                break;
        }
        dp[len] = result;
        return result;
    }
    
}