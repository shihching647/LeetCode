/**
 * 任何一個ugly number都是前面的ugly number乘上2或3或5
 * 參考: https://www.geeksforgeeks.org/ugly-numbers/ 的法二 
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] nums = new int[n];
        int[] index = new int[primes.length];
        int[] next = new int[primes.length];
        Arrays.fill(next, 1);
        int ugly = 1; //next ugly
        
        for (int i = 0; i < n; i++) {
            nums[i] = ugly;
            ugly = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                if (next[j] == nums[i]) {
                    next[j] = primes[j] * nums[index[j]++];
                }
                ugly = Math.min(ugly, next[j]);
            }
        }
        return nums[n - 1];
    }
}