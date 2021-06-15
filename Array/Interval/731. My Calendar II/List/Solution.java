/**
 * 重點一： 欲加入新的book區間時, 先去檢查overlap, 若有重疊就代表不能加入, 就retrun false
 *         (一開始是重calendars那個list想,所以卡住了)
 * 
 * 重點二： 判斷兩區間重疊有以下方法
 * 1. start小於interval的終點 && end大於interval的起點 (見圖片)
 * 2. 重疊 = !(沒有衝突) = !(end <= interval的起點 || start >= interval的終點) = start小於interval的終點 && end大於interval的起點
 * 3. 先將兩interval照start排序, 檢查小的interval終點 <= 大的interval的起點 -> true: 重疊, false: 不重疊 
 * 
 * Time complexity: O(n^2) (insert n times)
 * Space complexity: O(n)
 */
class MyCalendarTwo {
    
    private List<int[]> overlap;
    private List<int[]> calendar;
    
    public MyCalendarTwo() {
        overlap = new LinkedList<>();
        calendar = new LinkedList<>();
    }
    
    public boolean book(int start, int end) {
        for (int[] interval : overlap) {
            if (start < interval[1] && end > interval[0]) //這裡是AND,而不是OR
                return false;
        }
        for (int[] interval : calendar) {
            if (start < interval[1] && end > interval[0]) {
                overlap.add(new int[]{Math.max(start, interval[0]), Math.min(end, interval[1])});
            }
        }
        calendar.add(new int[]{start, end});
        return true;
    }

    // 判斷兩區間是否重疊(解答中沒用到, 只是另一種解法)
    private boolean isOverlap(int[] interval1, int[] interval2) {
        int[][] intervals = new int[][] {interval1, interval2};
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        if (intervals[0][1] <= intervals[1][0]) return false;
        return true;
    }
}