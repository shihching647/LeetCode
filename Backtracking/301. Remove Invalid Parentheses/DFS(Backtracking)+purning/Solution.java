/**
 * DFS/暴力法: 嘗試每一種移除的組合, 並使用Set來並免重複. (使用count來purning, 當count < 0時代表一定為不合法的括號)
 * 1.遇到'('可以選擇移除或不移除
 * 2.遇到')'可以選擇移除或不移除
 * 3.遇到英文字母一定不可移除
 *
 * 加上一種purning: 
 * 先檢查不match的左括號和右括號分別有幾個(leftCount, rightCount分別表示應該刪除的左括號和右括號)
 * 當任何一個小於0代表超過應刪除的量, 直接return
 * 
 * Time complexity: O(N * 2^N)
 * Space complexity: O(N)
 *
 */
class Solution {
    private int maxSize = -1;
    
    public List<String> removeInvalidParentheses(String s) {
        // 先檢查不match的左括號和右括號分別有幾個
        int leftCount = 0, rightCount = 0; // leftCount, rightCount分別表示應該刪除的左括號和右括號
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                leftCount++;
            } else if (c == ')') {
                if (leftCount > 0) {
                    leftCount--;
                } else {
                    rightCount++;
                }
            }
        }
        
        Set<String> result = new HashSet<>();
        remove(s, 0, new StringBuilder(), leftCount, rightCount, 0, result);
        return new ArrayList<>(result);
    }
    
    private void remove(String s, int index, StringBuilder sb, int leftCount, int rightCount, int count, Set<String> result) {
        if (count < 0 || leftCount < 0 || rightCount < 0)
            return;
        if (index == s.length()) {
            if (count == 0 && leftCount == 0 && rightCount == 0) {
                if (result.isEmpty() || sb.length() == maxSize) {
                    result.add(sb.toString());
                    maxSize = sb.length();
                } else if (maxSize < sb.length()) {
                    result = new HashSet<>();
                    result.add(sb.toString());
                    maxSize = sb.length();
                }
            }
            return;
        }
        char c = s.charAt(index);
        if (c == '(') {
            sb.append(c);
            remove(s, index + 1, sb, leftCount, rightCount, count + 1, result);
            sb.deleteCharAt(sb.length() - 1);
            remove(s, index + 1, sb, leftCount - 1, rightCount, count, result);
        } else if (c == ')') {
            sb.append(c);
            remove(s, index + 1, sb,leftCount, rightCount, count - 1, result);
            sb.deleteCharAt(sb.length() - 1);
            remove(s, index + 1, sb,leftCount, rightCount - 1, count, result);
        } else {
            sb.append(c);
            remove(s, index + 1, sb, leftCount, rightCount, count, result);
            sb.deleteCharAt(sb.length() - 1); 
        }
        return;
    }
}