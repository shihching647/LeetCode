/**
 * Backtracking: (recursion傳入len, 檢查right字串有沒有在dict內)
 * 將wordDict內的字所有可能都組起來.
 * 終止條件: len == 0
 * 
 * Time complexity: O(???)
 * Space complexity: O(N)
 */
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        HashSet<String> dict = new HashSet<>(wordDict);
        wordBreak(s, s.length(), dict, new StringBuilder() , result);
        return result;
    }
    
    private void wordBreak(String s, int len, HashSet<String> dict, StringBuilder sb, List<String> result) {
        if (len == 0) {
            result.add(sb.toString());
            return;
        }
        for (int i = 0; i < len; i++) {
            String right = s.substring(i, len); // i ~ len
            if (dict.contains(right)) {
                if (sb.length() > 0) {
                    sb.insert(0, right + " ");
                    wordBreak(s, i, dict, sb, result); // 傳入i
                    sb.delete(0, right.length() + 1);
                } else {
                    sb.insert(0, right);
                    wordBreak(s, i, dict, sb, result);
                    sb.delete(0, right.length());
                }
            }
        }
    }
}