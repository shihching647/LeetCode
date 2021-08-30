/**
 * 先把nums排序, For each nums[i], 
 * transfer 4Sumn to 3Sum question, then 3Sum to nums[j] + nums[k] = -nums[i] (Two Sum Problem) 
 * 
 * Improvement:
 * 1. 第一層回圈 nums[i] * 4 > target無解, 第二層迴圈 nums[i] + nums[j] * 3 > target無解
 * 2. 當有重複的元素時, 只需解一個就好, 後面都可跳過
 * 3. 每次加入一個解時, j, k都需跳過重複的元素避免重複解 (此方法可以避免使用set, 且較快)
 * 
 * Time complexity: O(n^3)
 * Space complexity: O(1)
 */
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        int n = nums.length;
        // 沒有解的情況
        if (n < 4 || nums[0] * 4 > target || nums[n - 1] * 4 < target)
            return result;
        
        for (int i = 0; i < n; i++) {
            if (nums[i] * 4 > target) // 沒有解
                break;
            if (i != 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] * 3 > target) // 沒有解
                    break;
                if (j != i + 1 && nums[j] == nums[j - 1])
                    continue;
                int k = j + 1, l = n - 1;
                while (k < l) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k++], nums[l--]));
                        while (k < l && nums[k] == nums[k - 1]) k++;
                        while (k < l && nums[l] == nums[l + 1]) l--;
                    } else if (sum < target) k++;
                    else l--;
                }
            }
        }
        
        return result;
    }
}