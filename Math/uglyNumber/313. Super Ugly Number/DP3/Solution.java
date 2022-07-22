/**
 * 任何一個ugly number都是前面的ugly number乘上任何一個primes
 * 一樣的概念, 只是多一個next[]存ugly number的candidate, 這樣可以少跑一次迴圈.
 * 
 * Time complexity: O(N*M) (primes.size() = M)
 * Space complexity: O(n)
 */

class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n];
        int[] index = new int[primes.length];
        int[] next = new int[primes.length];
        int ugly = 1;
        Arrays.fill(next, 1);
        
        for (int i = 0; i < n; i++) {
            dp[i] = ugly;
            ugly = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                if (primes[j] * dp[index[j]] > 0) {
                    if (dp[i] == next[j]) {
                        next[j] = primes[j] * dp[index[j]++];
                    }
                    ugly = Math.min(ugly, next[j]);
                }
            }
        }
        
        return dp[n - 1];
    }
}