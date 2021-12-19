/**
 * DP (Bottom Up): 
 * dp[i] = s.substring(i)可解密的數量
 * s.substring(i)的解密數量 = s.substring(i + 1)的解密數量 + s.substring(i + 2)的解密數量 (類似費氏數列)
 * 
 * 參考: https://www.youtube.com/watch?v=OjEHST4SXfE&ab_channel=HuaHua(解法一)
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
        
    public int numDecodings(String s) {
        int n = s.length();
        int p2 = 1; // 空字串為1種
        int p1 = s.charAt(n - 1) != '0' ? 1 : 0; // 最後一位為0的話為0種, 其他為1種
        int temp = 0;
        
        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') { // 為0的話一定不合法
                temp = 0;
            } else {
                temp = p1; // 第1位一定合法
                if (Integer.parseInt(s.substring(i, i + 2)) <= 26) { // 檢查兩位是否合法
                    temp += p2;
                }
            }
            p2 = p1;
            p1 = temp;
        }
        return p1;
    }
}