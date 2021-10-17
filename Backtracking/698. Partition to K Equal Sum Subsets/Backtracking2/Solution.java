/**
 * 從第一組subset開始找, 當有發現沒有使用過的元素時都填入該subset看看, 此組subset找完後在換下一組subset
 * 1.當k == 0時, 代表所有subset都找到, return true
 * 當subset的和大於target時代表不符合.
 * 
 * 
 * 參考: https://www.youtube.com/watch?v=zIY2BWdsbFs&ab_channel=HuaHua
 * Time complexity: O(K * 2 ^ N) (每一subset搜尋都要花2 ^ N(N個元素選or不選), 共有K個subset)
 * Space complexity: O(N)
 *
 */
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        if (sum % k != 0)
            return false;
        int target = sum / k;
        boolean[] marked = new boolean[nums.length];
        return helper(nums, 0, 0, target, k, marked);
    }
    
    // k為目前是找哪一組subset
    private boolean helper(int[] nums, int start, int sum, int target, int k, boolean[] marked) {
        if (k == 1) 
            return true; // 代表所有subset都找到
        if (sum > target)
            return false; // 某一組subset > target, 代表此種情形不可能
        if (sum == target)
            return helper(nums, 0, 0, target, k - 1, marked); // 此組subset找完, 換下一組, 此時start要歸0
        
        for (int i = start; i < nums.length; i++) {
            if (!marked[i]) {
                sum += nums[i];
                marked[i] = true;
                if (helper(nums, i + 1, sum, target, k, marked)) { // 因為此組subset i前面的都已經檢查過了, 所以直接從i + 1開始
                    return true;
                }
                sum -= nums[i];
                marked[i] = false;
            }
        }
        return false;
    }

}