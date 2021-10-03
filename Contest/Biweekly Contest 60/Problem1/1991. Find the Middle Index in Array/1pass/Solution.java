/**
 * leftSum + rightSum + nums[i] = totalSum
 * 2 * leftSum + nums[i] = totalSum
 * 把每一個i的2 * leftSum + nums[i]記錄下來(如果有重複, 紀錄最小的i)
 * 最後用totalSum當作key去找index
 * 
 * Time complexity: O(N) (1-pass)
 * Space complexity: O(N)
 *
 */

class Solution {
    public int findMiddleIndex(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int leftSum = 0;
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(2 * leftSum + nums[i], i); // 只紀錄最小的i
            leftSum += nums[i];
        }
        // 此時leftSum為totalSum
        return map.getOrDefault(leftSum, -1);
    }
}