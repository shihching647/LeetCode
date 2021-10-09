/**
 * 使用DP. DP[t] = target為t的所有組合.
 *
 * Time complexity: O(???)
 * Space complexity: O(???)
 *
 */
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>>[] dp = new List[target + 1];
        
        for (int t = 0; t < dp.length; t++) {
            List<List<Integer>> wrap = new LinkedList<>();
            for (int i = 0; i < candidates.length; i++) {
                int num = candidates[i];
                if (num > t) break;
                // special case for num == t
                if (num == t) wrap.add(Arrays.asList(num));
                // get from previous dp table
                for (List<Integer> preList : dp[t - num]) {
                    if (preList.get(preList.size() - 1) <= num) { // 只有當最後一個數比num小的時候才加入
                        List<Integer> list = new LinkedList<>(preList);
                        list.add(num);
                        wrap.add(list);
                    }
                }
            }
            // 回填dp
            dp[t] = wrap;
        }
        return dp[target];
    }
}