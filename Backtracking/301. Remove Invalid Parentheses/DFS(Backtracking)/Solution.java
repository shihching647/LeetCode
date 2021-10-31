/**
 * DFS/暴力法: 嘗試每一種移除的組合, 並使用Set來並免重複. (使用count來purning, 當count < 0時代表一定為不合法的括號)
 * 1.遇到'('可以選擇移除或不移除
 * 2.遇到')'可以選擇移除或不移除
 * 3.遇到英文字母一定不可移除
 * 
 * Time complexity: O(N * 2^N)
 * Space complexity: O(N)
 *
 */
class Solution {

    private int maxSize = -1; // 用來記錄目前存在Set裡面的字串長度是多少
    
    public List<String> removeInvalidParentheses(String s) {
        Set<String> result = new HashSet<>();
        remove(s, 0, new StringBuilder(), 0, result);
        return new ArrayList<>(result);
    }
    
    private void remove(String s, int index, StringBuilder sb, int count, Set<String> result) {
        // purning: count < 0一定不合法
        if (count < 0)
            return;
        if (index == s.length()) {
            if (count == 0) { // count為0才是合法的
                if (result.isEmpty() || sb.length() == maxSize) {
                    result.add(sb.toString());
                    maxSize = sb.length();
                } else if (maxSize < sb.length()) { // 若新的字串長度 > set裡面的, 清空set, 將新的加進去(題目要求留最大長度的字串)
                    result = new HashSet<>();
                    result.add(sb.toString());
                    maxSize = sb.length();
                }
            }
            return;
        }
        char c = s.charAt(index);
        if (c == '(') { // 1.遇到'('可以選擇移除或不移除
            sb.append(c);
            remove(s, index + 1, sb, count + 1, result);
            sb.deleteCharAt(sb.length() - 1);
            remove(s, index + 1, sb, count, result);
        } else if (c == ')') { // 2.遇到')'可以選擇移除或不移除
            sb.append(c);
            remove(s, index + 1, sb, count - 1, result);
            sb.deleteCharAt(sb.length() - 1);
            remove(s, index + 1, sb, count, result);
        } else { // 3.遇到英文字母一定不可移除
            sb.append(c);
            remove(s, index + 1, sb, count, result);
            sb.deleteCharAt(sb.length() - 1); 
        }
        return;
    }
}