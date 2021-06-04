/**
 * Greedy algorithm: (proof: https://www.youtube.com/watch?v=hVhOeaONg1Y&ab_channel=BackToBackSWE)
 * Sort the intervals by end point, then iterate all intervals,
 * pick the interval if the start point >= current minmum end.
 * 
 *  
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int maxCount = 0;
        int end = Integer.MIN_VALUE;
        for (int[] interval : intervals) {
            if (end <= interval[0]) {
                end = interval[1];
                maxCount++;
            }
        }
        return intervals.length - maxCount;
    }
}