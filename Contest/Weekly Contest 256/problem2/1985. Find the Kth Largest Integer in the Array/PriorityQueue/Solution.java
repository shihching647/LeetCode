/**
 * 使用Priority queue排序
 *
 * Time complexity: O(NlogN)
 * Space complexity: O(N)
 */
class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> pq = new PriorityQueue<>(
            (s1, s2) -> (s1.length() != s2.length()) ? s2.length() - s1.length() : s2.compareTo(s1)
        );
        for (String num : nums) {
            pq.offer(num);
        }
        for (int i = 0; i < k - 1; i++)
            pq.poll();
        return pq.peek();
    }
}