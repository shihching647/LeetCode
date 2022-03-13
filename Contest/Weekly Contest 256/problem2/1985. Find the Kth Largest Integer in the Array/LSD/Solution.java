/**
 * LSD排序
 *
 * Time complexity: O(N)
 * Space complexity: O(N)
 */
class Solution {
    
    private static int R = 11;
    
    public String kthLargestNumber(String[] nums, int k) {
        for (int d = 0; d < 100 ; d++) {
            int[] count = new int[R + 1];
            String[] aux = new String[nums.length];
            for (int i = 0; i < nums.length; i++) {
                count[charAt(nums[i], d) + 1]++;
            }
            
            for (int c = 0; c < R; c++) {
                count[c + 1] += count[c];
            }
            
            for (int i = 0; i < nums.length; i++) {
                aux[count[charAt(nums[i], d)]++] = nums[i];
            }
            
            for (int i = 0; i < nums.length; i++) {
                nums[i] = aux[i];
            }
        }
        return nums[nums.length - k];
    }
    
    // d是從最右邊那個數開始, 第d個位數
    private int charAt(String num, int d) {
        int length = num.length();
        if (length - 1 - d < 0)
            return 0; // d > length - 1時候, 回傳0
        else return num.charAt(length - 1 - d) - '0' + 1; // 0填入1, 1填入2...
    }
}