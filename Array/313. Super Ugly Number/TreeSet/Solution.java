/**
 * 使用TreeSet
 * 
 * Time complexity: O(N(MlogN)) (primes.size() = M)(TLE!!)
 * Space complexity: O(N)
 */

class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        TreeSet<Long> set = new TreeSet<>();
        int i = 1;
        set.add(1L);
        
        while (i < n) {
            long cur = set.pollFirst();
            for (int j = 0; j < primes.length; j++) {
                set.add(primes[j] * cur);
            }
            i++;
        }
        
        return set.pollFirst().intValue();
    }
}