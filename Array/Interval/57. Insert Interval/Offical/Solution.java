/**
 * 分三種情況: (1, 2為不重疊情形, 3為重疊)
 * 1. interval的右邊 < newInterval的左邊(表示interval與newInterval沒有重疊, 且interval排在newInterval的左邊)
 * 2. interval的左邊 > newInterval的右邊(表示interval與newInterval沒有重疊, 且newInterval排在interval的左邊)
 * 3. interval與newInterval有重疊, 更新newInterval的左右端點(因為原陣列內的線段都是不重疊的, 故重疊一定與newInterval有關)
 * (重疊條件為 --> interval的左邊 <= newInterval的右邊)
 *
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        if (n == 0) 
            return new int[][]{newInterval};
        
        LinkedList<int[]> result = new LinkedList<>();
        int[] temp = newInterval.clone(); // 用temp取代newInterval, 避免改到newInteravl
        
        for (int[] interval : intervals) {
            // temp == null(表示newInterval已經被加入) || interval的右邊 < newInterval的左邊(表示interval與newInterval沒有重疊, 且interval排在newInterval的左邊)
            if (temp == null || interval[1] < temp[0]) {
                result.add(interval);
            } else if (interval[0] > temp[1]) { // interval的左邊 > newInterval的右邊(表示interval與newInterval沒有重疊, 且newInterval排在interval的左邊)
                result.add(temp); // 先加入newInterval
                result.add(interval); // 再加入interval
                temp = null; // newInterval已被加入, 設成null
            } else { // interval與newInterval有重疊, 更新newInterval的左右端點(因為原陣列內的線段都是不重疊的, 故重疊一定與newInterval有關)
                temp[0] = Math.min(temp[0], interval[0]);
                temp[1] = Math.max(temp[1], interval[1]);
            }
        }
        // 若temp != null表示newInterval還沒被加入, 記得加入
        if (temp != null) 
            result.add(temp); 
        
        return result.toArray(new int[result.size()][2]);
    }
}