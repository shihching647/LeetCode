/**
 * Backtracking: (recursion傳入start, 檢查left字串有沒有在dict內)
 * 將wordDict內的字所有可能都組起來.
 * 終止條件: start == s.length()
 * 
 * Time complexity: O(???)
 * Space complexity: O(N)
 */
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        HashSet<String> dict = new HashSet<>(wordDict);
        wordBreak(s, 0, dict, new StringBuilder() , result);
        return result;
    }
    
    private void wordBreak(String s, int start, HashSet<String> dict, StringBuilder sb, List<String> result) {
        if (start == s.length()) {
            result.add(sb.toString());
            return;
        }
        for (int i = start; i < s.length(); i++) {
            String left = s.substring(start, i + 1); // start ~ i + 1
            if (dict.contains(left)) {
                if (sb.length() > 0) {
                    sb.append(" " + left);
                    wordBreak(s, i + 1, dict, sb, result); // 傳入i + 1
                    sb.delete(sb.length() - left.length() - 1, sb.length());
                } else {
                    sb.append(left);
                    wordBreak(s, i + 1, dict, sb, result);
                    sb.delete(sb.length() - left.length(), sb.length());
                }
            }
        }
    }
}