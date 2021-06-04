/**
 * Brute force:
 * 一開始先全部填入1, 在開始iterate, 每次發現比rating左右兩邊大且candy數比較小或相等, candy[i] + 1
 * 到最後會全部都滿足, hasChange就會變false. 
 * Worse case: [1,2,3,4,5]
 * Time complexity: O(n^2)
 * Space complexity: O(n)
 */


class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        boolean hasChanged = true;
        
        while (hasChanged) {
            hasChanged = false;
            for (int i = 0; i < n; i++) {
                int left = i - 1, right = i + 1;
                if (left >= 0 && ratings[i] > ratings[left] && candies[i] <= candies[left]) {
                    candies[i] += 1;
                    hasChanged = true;
                }
                if (right < n && ratings[i] > ratings[right] && candies[i] <= candies[right]) {
                    candies[i] += 1;
                    hasChanged = true;
                }
            }
        }
        
        int ans = 0;
        for (int x : candies) {
            ans += x;
        }
        return ans;
    }
}