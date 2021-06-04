/**
 * 先做binary search找到該插入的位置, 插入後在做merge intervals
 *
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        if (n == 0) 
            return new int[][]{newInterval};

        // binary search and insert
        int[][] temp = new int[n + 1][2];
        int j = binarySearch(intervals, newInterval[0]);
        for (int i = 0; i < temp.length; i++) {
            if (i < j) temp[i] = intervals[i];
            else if (i == j) temp[i] = newInterval;
            else temp[i] = intervals[i - 1]; 
        }

        // merge intervals
        LinkedList<int[]> result = new LinkedList<>();
        for (int[] interval : temp) {
            if (result.isEmpty() || result.getLast()[1] < interval[0]) {
                result.add(interval);
            } else {
                result.getLast()[1] = Math.max(result.getLast()[1], interval[1]);
            }
        }
        return result.toArray(new int[result.size()][2]);
    }

    private int binarySearch(int[][] intervals, int startEnd) {
        int i = 0;
        int j = intervals.length - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            int comp = Integer.compare(startEnd, intervals[mid][0]);
            if (comp == 0) return mid;
            else if (comp < 0) j = mid - 1;
            else i = mid + 1;
        }
        return i;
    }
}
