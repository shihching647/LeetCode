/**
 * 任何一個ugly number都是前面的ugly number乘上任何一個primes
 * 一樣的概念, 只是找min ugly number時是用priority queue
 * 
 * Time complexity: O(N*MlogN) (primes.size() = M)
 * Space complexity: O(n)
 */

class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] index = new int[primes.length];
        int[] nums = new int[n];
        nums[0] = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int prime : primes) {
            pq.offer(prime);
        }
        
        for (int i = 1; i < n; i++) {
            nums[i] = pq.peek();
            for (int j = 0; j < primes.length; j++) {
                if (nums[i] == primes[j] * nums[index[j]]) { // 發現重複, 重pq取出, 再把下一個放進去
                    pq.poll();
                    index[j]++;
                    pq.offer(primes[j] * nums[index[j]]);
                }
            }
        }
        return nums[n - 1];
    }
}