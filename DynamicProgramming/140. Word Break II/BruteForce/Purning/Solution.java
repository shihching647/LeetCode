/**
 * Recursion: 參考139的brute force方法, 使用sb來做purning, list來存目前考慮的String
 * 將wordDict內的字所有可能都組起來.
 * 終止條件: sb.length() > s.length()
 * 剪枝: 每次都先檢查sb內的字母是否都跟s一樣, 一但不一樣直接return
 * 
 * 參考: https://leetcode.wang/leetcode-139-Word-Break.html(法1)
 * Time complexity: O(???)
 * Space complexity: O(???)
 */
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        wordBreak(new StringBuilder(), s, wordDict, new ArrayList<>(), result);
        return result;
    }
    
    private void wordBreak(StringBuilder sb, String s, List<String> dict, List<String> list, List<String> result) {
        if (sb.length() > s.length())
            return;
        // purning
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != s.charAt(i))
                return;
        }
        if (sb.length() == s.length()) {
            result.add(String.join(" ", list));
            return;
        }
        for (String word : dict) {
            list.add(word);
            sb.append(word);
            wordBreak(sb, s, dict, list, result);
            list.remove(list.size() - 1);
            sb.delete(sb.length() - word.length(), sb.length());
        }
        return;
    }
}