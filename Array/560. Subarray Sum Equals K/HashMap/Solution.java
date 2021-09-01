/**
 * 使用HashMap紀錄目前爲止出現某個sum的次數(sum, 出現次數)
 * 每次Iteration都先檢查(sum - k)出現過的次數
 * (代表從0 ~ j的和為 (sum - k) , 0 ~ i的和為 sum, 故 j ~ i 的和為 k (sum - (sum - k))
 *  -> 滿足要找的答案, 故把ans加上他存在sumFrequency裡的次數)
 * 然後再更新sumFrequency
 * 
 * Time complexity: O(n)
 * Space complexity: O(n)
 */


class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> sumFrequency = new HashMap<>();
        // 不要忘記放, 出現sum = 0的次數有1
        // 因為當0 ~ i 的和剛好是k的時候, 若沒有這個條件, 則sumFrequency.containsKey(sum - k)不滿足就會沒算到
        sumFrequency.put(0, 1);
        int sum = 0, ans = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sumFrequency.containsKey(sum - k)) {
                ans += sumFrequency.get(sum - k);
            }
            sumFrequency.put(sum, sumFrequency.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}