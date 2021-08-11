/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

/**
 * Patience sort
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

        List<Integer> deck = new ArrayList<>(n);
        deck.add(nums[0]);
        for (int i = 1; i < n; i++) {
            int j = Collections.binarySearch(deck, nums[i]); // 如果沒有match, 回傳 -k - 1(k是應該要插入的位置)
            if (j < 0) {
                int pos = Math.abs(j + 1); // 換算成要取代的位置
                if (pos < deck.size()) {
                    deck.set(pos, nums[i]);
                } else {
                    deck.add(nums[i]);
                }
            }
        }
        return deck.size();
    }
    
}