/**
 * 用list存整個calendar
 * Time complexity: O(n^2) (insert n times)
 * Space complexity: O(n)
 */
class MyCalendar {
    
    private List<int[]> calendar;
    
    public MyCalendar() {
        calendar = new LinkedList<>();
    }
    
    public boolean book(int start, int end) {
        int[] newInterval = new int[] {start, end}; 
        for (int[] interval : calendar) {
            if (isOverlap(interval, newInterval))
                return false;
        }
        calendar.add(newInterval);
        return true;
    }
    
    private boolean isOverlap(int[] interval1, int[] interval2) {
        int[][] intervals = new int[][] {interval1, interval2};
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        if (intervals[0][1] <= intervals[1][0]) return false;
        return true;
    }
}