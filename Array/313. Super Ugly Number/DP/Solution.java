/**
 * 任何一個ugly number都是前面的ugly number乘上任何一個primes
 * 
 * Time complexity: O(N*M) (primes.size() = M)
 * Space complexity: O(n)
 */

class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int size = primes.length;
        int[] next = primes.clone();
        int[] index = new int[size];
        int[] nums = new int[n];
        nums[0] = 1;
        for (int i = 1; i < n; i++) {
            nums[i] = min(next); // 找最小的ugly number
            getNextNum(nums[i], nums, index, next, primes); // 把所有與ugly number相等的index都+1
        }
        return nums[n - 1];
    }
    
    private int min(int[] a) {
        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            min = Math.min(min, a[i]);
        }
        return min;
    }
    
    private void getNextNum(int min, int[] nums, int[] index, int[] next, int[] primes) {
        for (int i = 0; i < next.length; i++) {
            if (min == next[i]) {
                index[i]++;
                next[i] = nums[index[i]] * primes[i];
            }
        }
    }
}