/**
 * 只能往左轉(往右轉的不會改)
 * 
 *
 * 參考: https://www.youtube.com/watch?v=lzL4w624N_Y&ab_channel=DSAlgo
 * Time complexity: O(N)
 * Space complexity: O(1)
 */

class Solution {
     public void rotate(int nums[], int k) {
         int n = nums.length;
         int offset = (n - k) % n;
         int a = offset, b = n - offset; // a, b分別為左邊長度和右邊長度
         while (a != b) {
             if (a < b) {
                 swap(nums, offset - a, offset - a + b, a); // swap a, br(長度也是a), 長度a
                 b = b - a;
             } else {
                 swap(nums, offset - a, offset, b); // swap al(長度也是b), b, 長度b
                 a = a - b;
             }
         } 
         swap(nums, offset - a, offset, a);
     }

    private void swap(int[] nums, int a, int b, int k){
        for (int i = 0; i < k; i++) {
            int temp = nums[a + i];
            nums[a + i]= nums[b + i];
            nums[b + i]=temp; 
        }
    }
}