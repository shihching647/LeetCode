/**
 * DP(Bottom up)
 * DP[i]: 表示達成bitMap為i的skill組合所需的最少人組成的List, 答案為該DP陣列的最後一項
 * 
 * Time complexity: O(people * 2 ^ (skill))
 * Space complexity: O(2 ^ (skill))
 * 參考: https://leetcode.com/problems/smallest-sufficient-team/solutions/334572/java-c-python-dp-solution/
 *      https://www.youtube.com/watch?v=5Kr1PWAgEx8&ab_channel=HuaHua
 */
class Solution {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int n = req_skills.length;
        int m = people.size();

        // map (skill name -> skill index)
        HashMap<String, Integer> skillIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            skillIndex.put(req_skills[i], i);
        }

        // dp[skills] will contain the indices of the people required to satisfy the skills.
        // DP[i]表示達成bitMap為i的skill組合所需的最少人組成的List, 答案為該DP陣列的最後一項
        List<Integer>[] dp = new List[1 << n];

        for (int i = 0; i < m; i++) {

            // present the skill set in bitmap form
            int skillValue = 0;
            for (String skill : people.get(i)) {
                skillValue |= 1 << skillIndex.get(skill);
            }

            dp[0] = new ArrayList<>();
            for (int pre = 0; pre < dp.length; pre++) {
                if (dp[pre] == null) continue;
                int comb = pre | skillValue;
                // 兩種情況要加入dp陣列裡面
                // 1. 此技能的set沒有值時
                // 2. 前一次的組合人數(dp[comb].size) > 新的組合人數(dp[pre].size() + 1)
                if (dp[comb] == null || dp[comb].size() > dp[pre].size() + 1) {
                    dp[comb] = new ArrayList<>(dp[pre]);
                    dp[comb].add(i);
                }
            }
        }
        // 答案為該DP陣列的最後一項
        return dp[(1 << n) - 1].stream().mapToInt(i -> i).toArray();
    }
}