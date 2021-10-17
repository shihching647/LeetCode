/**
 * The idea is that we map each subset to a bitmask of length n, 
 * where 1 on the ith position in bitmask means the presence of nums[i] in the subset, and 0 means its absence.
 * 如: [1,2,3] N = 3
 * mask = [0,0,1], [0,1,0], [0,1,1], [1,0,0], [1,0,1], [1,1,0], [1,1,1]
 * 0代表要取, 1代表不取 
 *
 * 重複怎麼處理?
 * 當發現重複的數字時, 檢查前一個數字是否有被選中(前一個bit是否為1), 只有當前面被選中時才可加入答案中, 否則就是重複的.
 *
 * Time complexity: O(N * 2^N)
 * Space complexity: O(N * 2^N)
 *
 */
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> wrap = new LinkedList<>();
        int n = nums.length;
        for (int i = 0; i < (1 << n); i++) {
            List<Integer> list = new LinkedList<>();
            boolean isLegal = true;
            for (int b = 0; b < n; b++) {
                // 若此bit為1
                if ((i >> b & 1) == 1) { // 先往右移b個bit, 在檢查該bit是否為1
                    // 若前一個數字沒有被選中, 直接break
                    if (b > 0 && nums[b] == nums[b - 1] && (i >> (b - 1) & 1) == 0) {
                        isLegal = false;
                        break;
                    } else {
                        list.add(nums[b]);
                    }
                }
            }
            if (isLegal)
             wrap.add(list);
        }
        return wrap;
    }
}