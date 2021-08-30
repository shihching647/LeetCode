/**
 * 先把每個字母尋一遍找出每個字母最大及最小的位置存入intervalMap中,
 * -> 變成Problem56: Merge Intervals (已經sort了, 因為加入Map的順序就已經是照左邊end排序了)
 *
 * Time complexity: O(n)
 * Space complexity: O(1) (因為intervalMap.size()最大就是26)
 */
class Solution {
    public List<Integer> partitionLabels(String s) {
        // Map -> ('a', {3, 5})表示a的最小位置在3,最大位置在5
        Map<Character, int[]> intervalMap = new LinkedHashMap<>(); // LinkedHashMap(因為要保有順序)
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (intervalMap.containsKey(c)) {
                intervalMap.get(c)[1] = i;
            } else {
                int[] interval = {i, i};
                intervalMap.put(c, interval);
            }
        }
        // same as problem56: Merge Intervals (已經sort好了)
        LinkedList<Integer> list = new LinkedList<>();
        int preStart = -1; // 使用preStart, preEnd來記錄最後一個interval的區間
        int preEnd = -1;
        for (int[] interval : intervalMap.values()) {
            if (list.isEmpty() || preEnd < interval[0]) {
                preStart = interval[0];
                preEnd = interval[1];
                list.add(preEnd - preStart + 1);
            } else {
                preEnd = Math.max(preEnd, interval[1]);
                list.removeLast();
                list.add(preEnd - preStart + 1);
            }
        }
        return list;
    }
}