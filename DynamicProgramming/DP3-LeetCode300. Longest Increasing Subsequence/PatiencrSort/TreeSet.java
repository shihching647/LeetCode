/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

/**
 * Patience sort: 使用TreeSet implementation
 * 參考: https://www.youtube.com/watch?v=l2rCz7skAlk&ab_channel=HuaHua
 * 
 * Time Complexity: O(nlogn)
 * Space Complexity: O(n)
 * 
 **/
class Solution {
        
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            Integer x = set.ceiling(nums[i]); // 找到 min x (x >= nums[i]), 即為patience sort對應到的排堆
            if (x != null)
                set.remove(x);
            set.add(nums[i]);
        }
        return set.size();
    }
    
}