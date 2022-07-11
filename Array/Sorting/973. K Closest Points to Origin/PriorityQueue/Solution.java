/**
 * 使用Max PriorityQueue
 * 
 * Time complexity: O(NlogK)
 * Space complexity: O(K)
 */

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b[0] * b[0] + b[1] * b[1], a[0] * a[0] + a[1] * a[1])
        );
        for (int[] point : points) {
            pq.offer(point);
            if (pq.size() > k) {
                pq.poll(); // 移除最大的
            }
        }
        return pq.toArray(new int[k][2]);
    }
}