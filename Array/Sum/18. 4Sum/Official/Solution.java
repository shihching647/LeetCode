/**
 * 使用遞迴將4Sum -> 3Sum -> 2Sum
 * 
 * Time complexity: O(n^3)
 * Space complexity: O(n)
 */
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }
    
    private List<List<Integer>> kSum(int[] nums, int target, int start, int k) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        
        // 無解
        if (start == nums.length || nums[start] * k > target || nums[nums.length - 1] * k < target)
            return result;
        
        // terminate condition
        if (k == 2)
            return twoSum(nums, target, start);
        
        for (int i = start; i < nums.length; i++) {
            if (i != start && nums[i] == nums[i - 1])
                continue;
            for (var set : kSum(nums, target - nums[i], i + 1, k - 1)) { // 使用var, 呼叫kSum時, target記得要減nums[i], i要加1, k要減1
                result.add(new ArrayList(Arrays.asList(nums[i])));
                result.getLast().addAll(set); // 只有ArrayList才有addAll可使用
            }
        }
        return result;
    }
    
    // 這版的條件判斷須把 sum == target放在最後面, 如果把sum == target放在最前面會有重複的解加入到result中
    private List<List<Integer>> twoSum(int[] nums, int target, int start) {
        List<List<Integer>> result = new LinkedList<>();
        int i = start, j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum < target || i > start && nums[i] == nums[i - 1]) 
                i++;
            else if (sum > target || j < nums.length - 1 && nums[j] == nums[j + 1])
                j--;
            else if (sum == target) {
                result.add(Arrays.asList(nums[i++], nums[j--]));
            }
        }
        return result;
    }
}