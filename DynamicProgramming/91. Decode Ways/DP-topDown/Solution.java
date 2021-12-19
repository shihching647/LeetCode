/**
 * DP (Top Down): 
 * dp[i] = s.substring(i)可解密的數量
 * s.substring(i)的解密數量 = s.substring(i + 1)的解密數量 + s.substring(i + 2)的解密數量 (類似費氏數列)
 * 
 * 參考: https://www.youtube.com/watch?v=OjEHST4SXfE&ab_channel=HuaHua(解法一)
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {
        
    public int numDecodings(String s) {
        int[] dp = new int[s.length()]; // s.substring(i)可解密的數量
        Arrays.fill(dp, -1);
        return numDecodings(s, 0, dp);
    }
    
    private int numDecodings(String s, int i, int[] dp) {
        // 空字串為1種
        if (i >= s.length()) {
            return 1;
        }
        if (dp[i] >= 0)
            return dp[i];
        // 為0的話一定不合法, 直接return 0
        if (s.charAt(i) == '0') {
            dp[i] = 0;
            return 0;
        }
        // 否則第1位一定合法
        int result = numDecodings(s, i + 1, dp);
        // 檢查兩位是否合法
        if (i + 2 <= s.length() && Integer.parseInt(s.substring(i, i + 2)) <= 26)
            result += numDecodings(s, i + 2, dp);
        dp[i] = result;
        return result;
    }
}