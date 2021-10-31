/**
 * BFS: 因為題目要求刪除最小的括號數, 所以使用BFS來做
 * 每次檢查是否為合法字串, 若不合法, 嘗試將每一個括號都刪除, 並加到下一輪的queue裡
 * 
 * 不需要使用Set來當作移除重複.
 * 1. 加入到queue時, 多紀錄是移除了哪一個位置的括號. 當下一輪visit時, 只從該位置開始. 
 * 可避免下列這種重複:
 * (()(() -> ()(() -> ()()
 * (()(() -> (()() -> ()()
 *
 * 2. 當遇到連續相同的括號時, 只移除第一個, 可避免如 "(()"移除位置0, 1都可得到 "()"
 * 
 * Time complexity: O(N * 2^N)
 * Space complexity: O(2^N)
 *
 */
class Solution {    
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        Queue<Map.Entry<String, Integer>> q = new LinkedList<>(); // 多紀錄每次刪除的是哪一個位置
        q.offer(Map.entry(s, 0));
        while (!q.isEmpty()) {
            int n = q.size();
            for (int k = 0; k < n; k++) {
                Map.Entry<String, Integer> e = q.poll();
                String str = e.getKey();
                int startPos = e.getValue();
                if (isValid(str)) {
                    result.add(str);
                } else if (result.isEmpty()) {
                    StringBuilder sb = new StringBuilder(str);
                    for (int i = startPos; i < sb.length(); i++) { // 每次都從上一個刪除的位置之後開始檢查
                        char c = sb.charAt(i);
                        //避免重複, 當i為startPos(前面沒有任何字元)或不重複(不等於前一個時)才加入到BFS的queue中
                        if ((c == '(' || c == ')') && (i == startPos || str.charAt(i - 1) != str.charAt(i))) { 
                            sb.deleteCharAt(i);
                            String newStr = sb.toString();
                            q.offer(Map.entry(newStr, i));
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