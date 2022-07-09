/**
 * 與56題類似, 輪詢intervals, 每次順便檢查是否為newInterval要插入的位置
 *
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        LinkedList<int[]> result = new LinkedList<>();
        for (int i = 0; i < intervals.length; i++) {
            int[] insertInterval = intervals[i];
            if (newInterval != null && intervals[i][0] > newInterval[0]) {
                insertInterval = newInterval;
                i--;
                newInterval = null;
            }
            merge(result, insertInterval);
        }
        if (newInterval != null) {
            merge(result, newInterval);
        }
        return result.toArray(new int[result.size()][2]);
    }
    
    private void merge(LinkedList<int[]> result, int[] insertInterval) {
        if (result.isEmpty() || result.getLast()[1] < insertInterval[0]) {
            result.add(insertInterval);
        } else {
            result.getLast()[1] = Math.max(result.getLast()[1], insertInterval[1]);
        }
    }
}