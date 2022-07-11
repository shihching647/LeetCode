/**
 * 直接排序,取前K個
 * 
 * Time complexity: O(NlogN)
 * Space complexity: O(K) // 不算merge sort用到的
 */

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, (a, b) 
                    -> Integer.compare(a[0] * a[0] + a[1] * a[1], b[0] * b[0] + b[1] * b[1]));
        return Arrays.copyOf(points, k);
    }
}