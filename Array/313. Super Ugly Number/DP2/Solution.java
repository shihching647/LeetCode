/**
 * 任何一個ugly number都是前面的ugly number乘上2或3或5
 * 參考: https://www.geeksforgeeks.org/ugly-numbers/ 的法二 
 * Time complexity: O(n)
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