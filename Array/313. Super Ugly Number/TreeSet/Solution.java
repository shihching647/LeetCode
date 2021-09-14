/**
 * 使用TreeSet
 * 
 * Time complexity: O(N(MlogN)) (primes.size() = M)(TLE!!)
 * Space complexity: O(N)
 */

class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int count = 0;
        TreeSet<Long> set = new TreeSet<>();
        set.add(1L);
        long num = 1;
        while (count < n) {
            num = set.pollFirst();
            for (int i = 0; i < primes.length; i++) {
                set.add(num * primes[i]);
            }
            count++;
        }
        return (int) num;
    }
}