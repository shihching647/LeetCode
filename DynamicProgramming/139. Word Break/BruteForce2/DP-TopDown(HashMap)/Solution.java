/**
 * Recursion + DP(Top Down)
 * 將s的字串用wordDict內的字取代.
 * 終止條件: s只剩下'-'字符
 * 剪枝: ???目前沒有好方法???
 * 
 * Time complexity: TLE
 * Space complexity: O(???)
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashMap<String, Boolean> dp = new HashMap<>();
        return wordBreak(s, wordDict, dp);
    }
    
    private boolean wordBreak(String s, List<String> wordDict, HashMap<String, Boolean> dp) {
        if (s.replace("-","").isEmpty())
            return true;
        if (dp.containsKey(s))
            return dp.get(s);
        boolean result = false;
        for (String word : wordDict) {
            result = s.indexOf(word) >= 0 && wordBreak(s.replaceFirst(word, "-"), wordDict, dp);
            if (result) break;
        }
        dp.put(s, result);
        return result;
    }
}