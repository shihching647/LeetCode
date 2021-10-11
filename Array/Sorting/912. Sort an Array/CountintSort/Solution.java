/**
 * Counting sort
 * 
 * Time complexity: O(N)
 * Space complexity: O(M + 50000) (M為最nums[]中最大的數字)
 */

class Solution {
    private static final int OFF_SET = 50000;
    
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        // add OFF_SET(讓全部數字都 >= 0), find max
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            nums[i] += OFF_SET;
            max = Math.max(max, nums[i]);
        }
        
        // counting sort
        int R = max + 1; // 0 ~ max共 max + 1個數字
        int[] count = new int[R + 1];
        int[] aux = new int[n];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i] + 1]++;
        }
        
        for (int r = 0; r < R; r++)
            count[r + 1] += count[r];
        
        for (int i = 0; i < nums.length; i++) {
            aux[count[nums[i]]++] = nums[i];
        }
        
        for (int i = 0; i < aux.length; i++) {
            aux[i] -= OFF_SET;
        }
        return aux;
    }
}