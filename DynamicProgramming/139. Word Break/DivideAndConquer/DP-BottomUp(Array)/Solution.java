/**
 * Iteration + DP(Bottom Up)
 * dp[i] = s[0..i]是否可以被分割成wordDict內的字串
 * 
 * 參考: https://www.youtube.com/watch?v=il8Oi21WZN0&ab_channel=HuaHua
 * Time complexity: O(N ^ 2)
 * Space complexity: O(N)
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1]; // s[0..i]是否可以被分割成wordDict內的字串
        dp[0] = true; // 空字串為true(意義: 空字串可被分割成wordDict內的字串, 即不用分割的意思)
        
        for (int len = 1; len <= n; len++) {
            boolean result = false;
            for (int i = 0; i < len; i++) {
                result = dp[i] && dict.contains(s.substring(i, len));
                if (result) {
                    break;
                }
            }
            dp[len] = result;
        }
        
        return dp[n];
    }
}