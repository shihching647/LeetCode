/**
 * 可以work但看不懂(應該類似block swap???)
 * 
 * 參考: https://leetcode.com/problems/rotate-array/discuss/54263/3-lines-of-c-in-one-pass-using-swap
 * Time complexity: O(N)
 * Space complexity: O(1)
 */

class Solution {

     public void rotate(int nums[], int k) {
        int n = nums.length;
        k = k % n;
        for (int start = 0; start < nums.length && k != 0 ; k = k % n) {
            for (int i = 0; i < k; i++) {
                swap(nums, start + i, nums.length - k + i);
            }
            n = n - k;
            start = start + k;
        }
    }

    private static void swap(int[] nums, int a, int b){
        int temp = nums[b];
        nums[b] = nums[a];
        nums[a] = temp;
    }
}