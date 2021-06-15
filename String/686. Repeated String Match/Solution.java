/**
 * 先重複a, 直到b.length() < a.length()為止.
 * 檢查b是否為a的substring
 * 如果不是, 再加一次a, 若還不是那就回傳-1
 * 
 * A = "abc",  B = "bcabca"
 * 可以想像成把B拆成    "bc"   +   "abc"   + "ca"
 * 分為            前段不足的A + 中間x倍的A + 後段不足的A
 * 
 *
 * Time complexity: O(n / m) (m為a的長度, n為b的長度)
 * Space complexity: O(n + m)
 *
 */
class Solution {
    public int repeatedStringMatch(String a, String b) {
        int count = 1;
        StringBuilder sb = new StringBuilder(a);
        
        while (sb.length() < b.length()) {
            sb.append(a);
            count++;
        }

        // 把前段 + 中段補足 然後檢查
        if (sb.indexOf(b) != -1)
            return count;
        
        // 把後段補足然後檢查
        sb.append(a);
        return sb.indexOf(b) == -1 ? -1 : count + 1;
    }
}