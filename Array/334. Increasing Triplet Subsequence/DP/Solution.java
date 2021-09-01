/**
 * DP(參考:longest  increasing subsequence)
 * 
 * Time complexity: O(n^2)
 * Space complexity: O(n)
 */

class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        int[] table = new int[n]; // 定義為：結尾在i的longest incresing subsequence
        Arrays.fill(table, 1);
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    table[i] = Math.max(table[i], table[j] + 1);
                    if (table[i] >= 3) // 找到長度 >= 3即可返回true
                        return true;
                }
            }
        }
        return false;
    }
}