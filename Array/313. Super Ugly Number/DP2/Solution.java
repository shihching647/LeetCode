/**
 * 任何一個ugly number都是前面的ugly number乘上任何一個primes
 * Iteration 1 to n - 1:
 * 1.每次都從primes[j] * nums[index[j]] 找到最小值, 最小值即為下一個ugly number 
 * 2.找到下一個ugly number後, 在掃一次index, 若有一樣的值, index[j]也要+1
 * 
 * Time complexity: O(N*M) (primes.size() = M)
 * Space complexity: O(n)
 */

class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] index = new int[primes.length];
        int[] nums = new int[n];
        nums[0] = 1;
        
        for (int i = 1; i < n; i++) {
            nums[i] = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                nums[i] = Math.min(nums[i], primes[j] * nums[index[j]]);
            }
            for (int j = 0; j < primes.length; j++) {
                if (nums[i] == primes[j] * nums[index[j]]) {
                    index[j]++;
                }
            }
        }
        return nums[n - 1];
    }
}