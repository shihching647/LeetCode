/**
 * Use two pointer
 * 
 * Time complexity: O(n^2)
 * Space complexity: O(n) (java quick sort)
 */
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2]; // arbitrary ans
        
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                // if |sum - target| < |ans - target|, update ans
                if (Math.abs(sum - target) < Math.abs(ans - target)) {
                    ans = sum;
                }
                
                if (sum > target) k--;      // if sum > target, try smaller sum to approach target 
                else if (sum < target) j++; // if sum < target, try bigger sum to approach target 
                else return target;         // if sum == target, return target
            }
        }
        return ans;
    }
}