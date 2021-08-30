/**
 * 先把nums排序, For each nums[i], 
 * transfer 3Sum question to nums[j] + nums[k] = -nums[i] (Two Sum Problem) 
 * 
 * Time complexity: O(n^2)
 * Space complexity: O(1)
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>(); // 使用set, List的equals是deepEquals ((1,2,3) == (1,2,3)), 故重複的不會加入
        if (nums.length >= 3) {
            for (int i = 0; i < nums.length; i++) {
                // 當有重複的元素時, 只需解一個就好, 後面都可跳過 
                if (i != 0 && nums[i] == nums[i - 1])
                    continue;
                // 2Sum problme -> two pointer解
                int j = i + 1, k = nums.length - 1;
                while (j < k) {
                    int sum = nums[j] + nums[k];
                    if (sum + nums[i] == 0) {
                        List<Integer> list = Arrays.asList(nums[i], nums[j++], nums[k--]);
                        result.add(list);
                    } else if (sum + nums[i] < 0) j++;
                    else k--;
                }
            }
        }
        
        return new ArrayList<List<Integer>>(result);
    }
}