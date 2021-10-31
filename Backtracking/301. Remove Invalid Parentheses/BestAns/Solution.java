/**
 * 1.從頭開始檢查close括號是否為合法(count >= 0), 當發現count < 0時, 移除前面的close括號
 * 並使用此合法的括號繼續往下檢查.
 * 
 * 2.相同邏輯, 反向做一次(先將str反轉, 此時close括號和open括號會對調)
 * 
 * 
 * 參考: https://www.youtube.com/watch?v=lEMDEmQje1Q&ab_channel=happygirlzt
 * Time complexity: O(N * 2^N)
 * Space complexity: O(2^N)
 *
 */
class Solution {    
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        remove(s, result, 0, 0, false);
        return result;
    }
    
    // left之前的字串表示已經確認為最終答案應該包含的字元
    // right之前的字串表示已經檢查過且合法的括號
    private void remove(String s, List<String> result, int left, int right, boolean isReversed) {
        char open = '(', close = ')';
        if (isReversed) {
            open = ')';
            close = '(';
        }
        int stackCount = 0;
        int i = right; // 從right開始繼續檢查
        for (; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == open) stackCount++;
            else if (c == close) stackCount--;
            if (stackCount < 0) break; // 直接跳出, 因為前面已經發現不合法了, 再下去就沒意義了. 須先跳出回圈, 使得前面的合法, 再由遞迴呼叫繼續檢查後面
        }
        
        if (stackCount < 0) { // 發現close括號不合法
            for (int j = left; j <= i; j++) { // 從left ~ i發現不合法的字串, 先讓他合法, 在遞迴呼叫後面的檢查
                char c = s.charAt(j);
                if (c == close && (j == left || s.charAt(j - 1) != s.charAt(j))) {
                    String newStr = s.substring(0, j) + s.substring(j + 1);
                    remove(newStr, result, j, i, isReversed);
                }
            }
        } else if (stackCount > 0) { // close括號合法, 但open括號不合法, 反向檢查一次
            String reversedStr = new StringBuilder(s).reverse().toString();
            remove(reversedStr, result, 0, 0, true);
        } else { // 兩者都合法加到result中
            if (isReversed) result.add(new StringBuilder(s).reverse().toString());
            else result.add(s);
        }
    }
}