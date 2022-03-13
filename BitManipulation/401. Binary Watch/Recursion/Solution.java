/**
 * 
 * Time complexity: O(??)
 * Space complexity: O(10)
 *
 */

class Solution {
    
    private boolean[] hour = new boolean[4];
    private boolean[] minute = new boolean[6];
    private int h, m;
    
    public List<String> readBinaryWatch(int turnedOn) {
        Set<String> set = new HashSet<>();
        readWatch(turnedOn, set);
        return new ArrayList<>(set);
    }
    
    private void readWatch(int turnedOn, Set<String> set) {
        if (turnedOn == 0) {
            set.add(h + ":" + (m < 10 ? "0" + m : m));
            return;
        }
        for (int i = 0; i < hour.length; i++) {
            if (!hour[i]) {
                hour[i] = true;
                h += (1 << i);
                if (h <= 11) {
                    readWatch(turnedOn - 1, set);
                }
                h -= Math.pow(2, i);
                hour[i] = false; 
            }
        }
        
        for (int i = 0; i < minute.length; i++) {
            if (!minute[i]) {
                minute[i] = true;
                m += (1 << i);
                if (m <= 59) {
                    readWatch(turnedOn - 1, set);       
                }
                m -= Math.pow(2, i);
                minute[i] = false;   
            }
        }
    }
}