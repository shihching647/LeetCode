/**
 * 先把nums排序, For each nums[i], 
 * transfer 3Sum question to nums[j] + nums[k] = -nums[i] (Two Sum Problem) 
 * 
 * Improvement:
 * 1. 假如第一個數字已經大於0了, 後面不可能有解 (因為已經排序)
 * 2. 當有重複的元素時, 只需解一個就好, 後面都可跳過
 * 3. 每次加入一個解時, j, k都需跳過重複的元素避免重複解 (此方法可以避免使用set, 且較快)
 * 
 * Time complexity: O(n^2)
 * Space complexity: O(1)
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>(); // 使用list就好
        if (nums.length >= 3) {
            for (int i = 0; i < nums.length; i++) {
                // improve, 假如第一個數字已經大於0了, 後面不可能有解
                if (nums[i] > 0) 
                    break;
                
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
                        // 跳過重複的元素
                        while (j < nums.length && nums[j] == nums[j - 1]) j++;
                        while (j < k && nums[k] == nums[k + 1]) k--;
                    } else if (sum + nums[i] < 0) j++;
                    else k--;
                }
            }
        }
        
        return result;
    }
}