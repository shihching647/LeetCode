/**
 * 用TreeMap紀錄, 目前所有的區間, 遇到start time在record紀錄+1, 遇到end time在record紀錄 - 1
 * 所以在任一時間區間內的總數就代表，在那時間點同時發生的booking數
 * 註: 用這種算法無法得知, 目前存了哪些區間或是哪些區間重疊, 只能知道任一時間點有幾個重疊數.
 * 
 * Time complexity: O(n^2) (insert n times)
 * Space complexity: O(n)
 */
class MyCalendarThree {
    
    TreeMap<Integer, Integer> record;
        
    public MyCalendarThree() {
        record = new TreeMap<>();
    }
    
    public int book(int start, int end) {
        record.put(start, record.getOrDefault(start, 0) + 1);
        record.put(end, record.getOrDefault(end, 0) - 1);
        
        int active = 0;
        int max = 0;
        for (int check : record.values()) {
            active += check;
            if (active == 0) {
                record.remove(check);
            }
            max = Math.max(active, max);
        }
        return max;
    }
}
