/**
 * Recursion + DP(Top Down)
 * 使用HashMap來記錄String可拆解成dict內的所有解
 * 
 * 參考: https://www.youtube.com/watch?v=JqOIRBC0_9c&ab_channel=HuaHua
 * Time complexity: O(???)
 * Space complexity: O(N)
 */
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<>(wordDict);
        HashMap<String, List<String>> dp = new HashMap<>();
        return wordBreak(s, dict, dp);
    }
    
    private List<String> wordBreak(String s, HashSet<String> dict, HashMap<String, List<String>> dp) {
        if (dp.containsKey(s))
            return dp.get(s);
        
        List<String> ans = new ArrayList<>();
        
        // 若s本身就已經在dict內, 直接加到ans裡面
        if (dict.contains(s))
            ans.add(s);
        
        // 分割點從1開始 (因為i = 0已經在上面考慮過. i = 0放在這考慮的話, 會造成wordBreak("", dict, dp)的情況, 會回傳空的list, 導致沒有加到ans中)
        for (int i = 1; i < s.length(); i++) {
            String left = s.substring(0, i);
            String right = s.substring(i);
            if (dict.contains(right)) {
                ans.addAll(append(wordBreak(left, dict, dp), right));
            }
        }
        dp.put(s, ans);
        return ans;
    }
    
    private List<String> append(List<String> list, String suffix) {
        // 這邊要用新的List去裝, 避免改到存在dp裡的list
        List<String> newList = new ArrayList<>();
        for (String s : list) {
            newList.add(s + " " + suffix);
        }
        return newList; 
    }
}