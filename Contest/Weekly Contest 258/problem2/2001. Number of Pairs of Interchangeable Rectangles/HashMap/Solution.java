/**
 * 使用map紀錄每個ratio的count數有幾個. 從最後一個往前oterate, 遇到相同的 w/h 就從map取得之後的總數有幾個.
 * (Double可以當作key使用, 若想要更精確可用BigDecimal)
 *
 * Time complexity: O(N)
 * Space complexity: O(N)
 */
class Solution {
    
    public long interchangeableRectangles(int[][] rectangles) {
        HashMap<Double, Integer> map = new HashMap<>();
        long result = 0;
        for (int i = rectangles.length - 1; i >= 0; i--) {
            int w = rectangles[i][0];
            int h = rectangles[i][1];
            double ratio = w * 1.0 / h;
            int count = map.getOrDefault(ratio, 0);
            result += count;
            map.put(ratio, count + 1);
        }
        return result;
    }
}