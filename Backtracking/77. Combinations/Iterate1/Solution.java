/**
 * 將Backtracking的遞迴寫法改寫成Iterate
 * 
 * Time complexity: O(C(n, k))
 * Space complexity: O(C(n, k))
 *
 */
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>(k);

        // 先將k個0加到list中
        for (int i = 0; i < k; i++)
            list.add(0);
        
        int i = 0; // 用i來表示Backtacking的深度
        while (i >= 0) { // 結束時i == -1
            // 當前數字加一
            list.set(i, list.get(i) + 1);
            // 當前數字大於n，對應Backtracking的 i == n + 1，然後回到上一層
            if (list.get(i) > n) {
                i--;
            } else if (i == k - 1) { // 找到解
                result.add(new ArrayList<>(list));
            } else { // 更新下一個數字(Backtracking i++)
                i++;
                list.set(i, list.get(i - 1)); // 更新該數字
            }
        }
        return result;
    }
}