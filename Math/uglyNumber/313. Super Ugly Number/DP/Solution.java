/**
 * 任何一個ugly number都是前面的ugly number乘上任何一個primes
 * 
 * Time complexity: O(N*M) (primes.size() = M)
 * Space complexity: O(n)
 */

class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n];
        dp[0] = 1;
        int[] index = new int[primes.length];
        for (int i = 1; i < n; i++) {
            dp[i] = getNext(primes, index, dp);
            forward(primes, index, dp, dp[i]);
        }
        return dp[n - 1];
    }
    
    private int getNext(int[] primes, int[] index, int[] dp) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < primes.length; i++)
            if (primes[i] * dp[index[i]] > 0)
                min = Math.min(min, primes[i] * dp[index[i]]);
        return min;
    }
    
    private void forward(int[] primes, int[] index, int[] dp, int cur) {
        for (int i = 0; i < primes.length; i++) {
            if (primes[i] * dp[index[i]] == cur) {
                index[i]++;
            }
        }
    }
}