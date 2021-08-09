/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

/**
 * Tabulation(Bottom up) dynamic programming
 * 參考: https://www.youtube.com/watch?v=7DKFpWnaxLI&ab_channel=HuaHua
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 */

class Solution {
        
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;
        
        int[] table = new int[n];
        Arrays.fill(table, 1); // 初始值都是1
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    table[i] = Math.max(table[i], table[j] + 1);
                }
            }
        }
        
        int maxLength = 0;
        for (int i = 0; i < table.length; i++)
            maxLength = Math.max(maxLength, table[i]);
        
        return maxLength;
    }
    
}