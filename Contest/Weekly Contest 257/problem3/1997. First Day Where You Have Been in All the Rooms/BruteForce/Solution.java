/**
 * 照定義Brute Force
 *
 * Time complexity: O()
 * Space complexity: O(N)
 */

class Solution {
    
    private static final int NUMBER = 1000000007;
    
    public int firstDayBeenInAllRooms(int[] nextVisit) {
        int n = nextVisit.length;
        boolean[] freq = new boolean[n];
        int days = 0;
        int curRoom = 0;
        while (curRoom < n - 1) {
            freq[curRoom] = !freq[curRoom];
            if (freq[curRoom]) { // true -> 奇數
                curRoom = nextVisit[curRoom];
            } else { // 偶數
                curRoom = (curRoom + 1) % n;
            }
            days %= NUMBER;
            days++;
        }
        return days;
    }
}