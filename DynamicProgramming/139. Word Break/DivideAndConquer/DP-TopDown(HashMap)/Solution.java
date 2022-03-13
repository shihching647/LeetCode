/**
 * Recursion + DP(Top Down)
 * 使用HashMap來記錄String是否可拆解成dict內的字串
 * 
 * 參考: https://www.youtube.com/watch?v=ptlwluzeC1I&ab_channel=HuaHua
 * Time complexity: O(N ^ 2)
 * Space complexity: O(N)
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<>(wordDict);
        HashMap<String, Boolean> dp = new HashMap<>();
        return wordBreak(s, dict, dp);
    }
    
    private boolean wordBreak(String s, Set<String> dict, HashMap<String, Boolean> dp) {
        if (s.length() == 0)
            return true;
        if (dp.containsKey(s))
            return dp.get(s);
        boolean result = false;
         // 找分割點
        for (int i = 0; i < s.length(); i++) {
            String left = s.substring(0, i); // left用來傳入wordBreak
            String right = s.substring(i);   // right用來檢查是否有在字典內
            result = wordBreak(left, dict, dp) && dict.contains(right);
            if (result)
                break;
        }
        dp.put(s, result);
        return result;
    }
    
}