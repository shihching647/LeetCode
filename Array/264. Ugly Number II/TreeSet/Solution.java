/**
 * 參考: https://www.geeksforgeeks.org/ugly-numbers/ 的法三 
 * Time complexity: O(NlogN)
 * Space complexity: O(N)
 */

class Solution {
    public int nthUglyNumber(int n) {
        TreeSet<Long> set = new TreeSet<>(); // 要用long, 否則會overflow
        int i = 1;
        set.add(1L);
        while (i < n) {
            long ith = set.pollFirst();
            set.add(ith * 2);
            set.add(ith * 3);
            set.add(ith * 5);
            i++;  
            // the first element of set is always the ith ugly number
        }
        
        return set.pollFirst().intValue();
    }
}