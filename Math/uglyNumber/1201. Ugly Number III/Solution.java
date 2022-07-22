/**
 * 先求出小於任ㄧ數mid的醜數k
 * (a的倍數個數 + b的倍數個數 + c的倍數個數 - ab最小公倍數的個數 - bc最小公倍數的個數 - ca最小公倍數的個數 + abc最小公倍數的個數)
 * 再使用binary search找出第n個醜數
 * 
 * Binary search template
 * 
    while(lo < hi) {
        int mid = lo + (hi - lo) / 2;
        if(Special condition passed)(optional):
            return mid; 
        if(condition passed)
          hi = mid;
        else 
          lo = mid + 1;
    }
    return lo;
 * 
 * Time complexity: O(logN)
 * Space complexity: O(1)
 */

class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        long l = 1, r = Long.MAX_VALUE;
        long ab = lcm(a, b);
        long bc = lcm(b, c);
        long ca = lcm(c, a);
        long abc = lcm(c, ab);
        while (l < r) {
            long mid = l + (r - l) / 2;
            long k = mid / a + mid / b + mid / c - mid / ab - mid / bc - mid / ca + mid / abc; // 小於mid的醜數共有k個
            if (k >= n) r = mid;
            else l = mid + 1;
        }
        return (int) l;
    }

    private long lcm(long a, long b) {
        return (a / gcd(a, b)) * b * 1L;
    }
    private long gcd(long a, long b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

}