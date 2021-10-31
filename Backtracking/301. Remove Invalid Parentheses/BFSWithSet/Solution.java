/**
 * BFS: 因為題目要求刪除最小的括號數, 所以使用BFS來做
 * 每次檢查是否為合法字串, 若不合法, 嘗試將每一個括號都刪除, 並加到下一輪的queue裡
 * 
 * Time complexity: O(N * 2^N)
 * Space complexity: O(2^N)
 *
 */
class Solution {    
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        Set<String> visited = new HashSet<>(); // 避免重複, 使用visited來記錄已經加入的字串
        Queue<String> q = new LinkedList<>();
        q.offer(s);
        visited.add(s);
        while (!q.isEmpty()) {
            int n = q.size();
            for (int k = 0; k < n; k++) {
                String str = q.poll();
                if (isValid(str)) {
                    result.add(str);
                } else if (result.isEmpty()) { // 若result不為空, 就代表沒有下一輪, 就不需要再加入到queue中了
                    // 嘗試將每一個括號都刪除
                    StringBuilder sb = new StringBuilder(str);
                    for (int i = 0; i < sb.length(); i++) {
                        char c = sb.charAt(i);
                        if (c == '(' || c == ')') {
                            sb.deleteCharAt(i);
                            String newStr = sb.toString();
                            if (!visited.contains(newStr)) {
                                q.offer(newStr);
                                visited.add(newStr);
                            }
                            sb.insert(i, c);
                        }
                    }
                }
            }
            if (!result.isEmpty())
                break;
        }
        return result;
    }
    
    private boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
            }
            if (count < 0)
                return false;
        }
        return count == 0;
    }
}