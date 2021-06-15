/**
 * 用TreeMap紀錄, 目前所有的區間, 遇到start time在record紀錄+1, 遇到end time在record紀錄 - 1
 * 所以在任一時間區間內的總數就代表，在那時間點同時發生的booking數, 若超過3就代表超過3個booking
 * 註: 用這種算法無法得知, 目前存了哪些區間或是哪些區間重疊, 只能知道任一時間點有幾個重疊數.
 * 
 * Time complexity: O(n^2) (insert n times)
 * Space complexity: O(n)
 */
class MyCalendarTwo {
    
    private TreeMap<Integer, Integer> record;
    
    public MyCalendarTwo() {
        record = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        record.put(start, record.getOrDefault(start, 0) + 1);
        record.put(end, record.getOrDefault(end, 0) - 1);
        
        int active = 0; // 用來記錄目前booking數
        for (int checkPoint: record.values()) {
            active += checkPoint;
            if (active >= 3) {
                record.put(start, record.get(start) - 1); // 把新增的移除(因為不能新增)
                record.put(end, record.get(end) + 1);   // 把新增的移除(因為不能新增)
                if (record.get(start) == 0) record.remove(start); // 若start的booking數已變成0, 就把它移除
                if (record.get(end) == 0) record.remove(end);     // 若end的booking數已變成0, 就把它移除
                return false;
            }
        }
        return true;
    }
    
}