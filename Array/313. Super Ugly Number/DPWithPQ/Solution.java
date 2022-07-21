/**
 * 任何一個ugly number都是前面的ugly number乘上任何一個primes
 * 一樣的概念, 只是找min ugly number時是用priority queue
 * 
 * Time complexity: O(N*MlogM) (primes.size() = M)
 * Space complexity: O(n)
 */

class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n];
        int[] index = new int[primes.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int prime : primes) {
            pq.offer(prime);
        }
        dp[0] = 1;
        
        for (int i = 1; i < n; i++) {
            dp[i] = pq.peek();
            for (int j = 0; j < primes.length; j++) {
                if (dp[i] == primes[j] * dp[index[j]]) {
                    pq.poll();
                    index[j]++;
                    if (primes[j] * dp[index[j]] > 0) // 防止overflow
                        pq.offer(primes[j] * dp[index[j]]);
                }
            }
        }
        
        return dp[n - 1];
    }
}