/**
 * 把每可能的時間檢查過一次, 若是bit的sum等於turnedOn的數字, 就代表這是一種可能的組合.
 *
 * Time complexity: O(12 * 60)
 * Space complexity: O(12 * 60)
 *
 */

class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> list = new LinkedList<>();
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    list.add(h + ":" + (m < 10 ? "0" + m : m));
                }
            }
        }
        return list;
    }
}