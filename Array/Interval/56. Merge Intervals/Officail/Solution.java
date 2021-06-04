/**
 * 先對intervals的左邊端點排序, 當result為空的時候都先加入到result, 
 * 遇到新的interval時候, 再把result最後一個拿出來更新
 *
 * Time complexity: O(nlogn)
 * Space complexity: O(n)
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0])); // compare the start of interval
        LinkedList<int[]> result = new LinkedList<>();
        for (int[] interval : intervals) {
            // result是空的，或是result的最後一個的右邊端點 < 目前這個左邊端點(表示兩個interval沒有相交)
            if (result.isEmpty() || result.getLast()[1] < interval[0]) {
                result.add(interval);
            } else {
                // 有相交只需更新右邊端點
                // 左邊端點不需要更新, 因為intervals已經照左邊端點排序了
                result.getLast()[1] = Math.max(result.getLast()[1], interval[1]);
            }
        }
        return result.toArray(new int[result.size()][]); // 回傳array(List轉成Array可參考下面網址)
        // https://www.geeksforgeeks.org/arraylist-array-conversion-java-toarray-methods/
    }
}
