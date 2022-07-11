/**
 * 使用每一個index i 當作起點, 找到該起點最長的substring
 * 
 * Time complexity: O(N ^ 2)
 * Space complexity: O(128)
 *
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            boolean[] map = new boolean[128];
            int max = 0;
            for (int j = i; j < s.length() && !map[s.charAt(j)]; j++) {
                map[s.charAt(j)] = true;
                max++;
            }
            ans = Math.max(ans, max);
        }
        return ans;
    }
}