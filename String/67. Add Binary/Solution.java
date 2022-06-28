/**
 * 字串相加都可以用
 * sum % 2加到前面和sum / 2進位
 * 
 * Time complexity: O(max(n, m)) (m為a的長度, n為b的長度)
 * Space complexity: O(max(n, m))
 *
 */
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry > 0) sb.append('1');
        return sb.reverse().toString();
    }
}