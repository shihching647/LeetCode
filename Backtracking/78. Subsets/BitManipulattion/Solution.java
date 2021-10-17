/**
 * The idea is that we map each subset to a bitmask of length n, 
 * where 1 on the ith position in bitmask means the presence of nums[i] in the subset, and 0 means its absence.
 * 如: [1,2,3] N = 3
 * mask = [0,0,1], [0,1,0], [0,1,1], [1,0,0], [1,0,1], [1,1,0], [1,1,1]
 * 0代表要取, 1代表不取 
 *
 * Time complexity: O(N * 2^N)
 * Space complexity: O(N * 2^N)
 *
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> wrap = new LinkedList<>();
        int n = nums.length;
        // 從 2^N ~ 2^(N+1)取得mask
        // 如N = 3, i從1000 ~ 1111 => 取substring(1) => 000 ~ 111
        for (int i = (1 << n); i < (1 << (n + 1)); i++) {
            String mask = Integer.toBinaryString(i).substring(1);
            List<Integer> list = new LinkedList<>();
            for (int c = 0; c < n; c++) {
                if (mask.charAt(c) == '1')
                    list.add(nums[c]);
            }
            wrap.add(list);
        }
        return wrap;
    }
}