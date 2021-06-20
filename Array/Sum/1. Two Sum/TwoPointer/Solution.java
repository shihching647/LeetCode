/**
 * Sort the array and use two pointer find the two sum,
 * iterate all elements find the two index. 
 * 
 * Time complexity: O(nlogn)
 * Space complexity: O(n)
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {

        // use temp sort the input array O(nlogn)
        int[] temp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(temp);
        
        // Two pointer, find the two sum. O(n)
        int j = 0, k = nums.length - 1;
        while (j < k) {
            int sum = temp[j] + temp[k];
            if (sum < target) j++;
            else if (sum > target) k--;
            else break;
        }

        // Find index in the input array. O(n)
        int i1 = -1, i2 = -1;
        for (int i = 0; i < nums.length; i++) {
            if (i1 < 0 && nums[i] == temp[j])
                i1 = i;
            else if (i2 < 0 && nums[i] == temp[k])
                i2 = i;
        }
        
        return new int[]{i1, i2};
    }
}