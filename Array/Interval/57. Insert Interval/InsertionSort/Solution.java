/**
 * 先用insertion sort找到newInterval的位置, 再調用56題的merge intervals
 *
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] temp = new int[intervals.length + 1][2];
        System.arraycopy(intervals, 0, temp, 0, intervals.length);
        temp[temp.length - 1] = newInterval;
        
        // insertion sort
        int i = temp.length - 1;
        while(i > 0 && temp[i - 1][0] > newInterval[0]) {
            temp[i] = temp[i - 1];
            i--;
        }
        temp[i] = newInterval;
        
        // 與56題一樣
        LinkedList<int[]> result = new LinkedList<>();
        for (i = 0; i < temp.length; i++) {
            if (result.isEmpty() || result.getLast()[1] < temp[i][0]) {
                result.add(temp[i]);
            } else {
                result.getLast()[1] = Math.max(result.getLast()[1], temp[i][1]);
            }
        }
        
        return result.toArray(new int[result.size()][2]);
    }
}