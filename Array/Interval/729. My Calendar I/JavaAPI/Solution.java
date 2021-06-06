/**
 * 用tree存整個calendar
 * Time complexity: O(nlogn) (insert n times)
 * Space complexity: O(n)
 */
class MyCalendar {
    TreeMap<Integer, Integer> calendar;

    MyCalendar() {
        calendar = new TreeMap();
    }

    public boolean book(int start, int end) {
        Integer pre = calendar.floorKey(start);
        Integer next = calendar.ceilingKey(start);
        if ((pre == null || calendar.get(pre) <= start) && (next == null || next >= end)) {
            calendar.put(start, end);
            return true;
        }
        return false;
    }
}