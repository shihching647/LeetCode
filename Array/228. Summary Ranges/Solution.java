/**
 * Two pointer
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

class Solution {
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        if (n == 0) 
            return new ArrayList<>();
        
        List<String> result = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < n; i++) {
            if (i == n - 1 || nums[i + 1] - nums[i] != 1) {
                if (start == end) 
                    result.add(Integer.toString(nums[start]));
                else 
                    result.add(nums[start] + "->" + nums[end]);
                start = end = i + 1;
            } else {
                end++;
            }
        }
        return result;
    }
}