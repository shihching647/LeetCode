/**
 * 將小於newInterval的區間分到左
 * 與newInterval重疊部分分到中間
 * 大於newInterval的區間分到右
 * 答案 = left + mid + right
 * 
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        LinkedList<int[]> left = new LinkedList<>();
        LinkedList<int[]> right = new LinkedList<>();
        int[] mid = newInterval.clone();
        
        for (int[] interval : intervals) {
            if (interval[1] < newInterval[0]) {
                left.add(interval);
            } else if (interval[0] > newInterval[1]) {
                right.add(interval);
            } else {
                mid[0] = Math.min(mid[0], interval[0]);
                mid[1] = Math.max(mid[1], interval[1]);
            }
        }
        left.add(mid);
        left.addAll(right);
        return left.toArray(new int[left.size()][2]);
    }
}