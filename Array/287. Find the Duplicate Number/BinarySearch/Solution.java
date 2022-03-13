/**
 * 使用小於等於x的個數有幾個作Binary Search
 * 如: [1,2,3,4,4,5] -> 小於等於1的個數有1個, 2的個數有2, 3的個數有3個, 4的個數有5個, 5的個數有6個 
 *                   -> 找最小的數使得小於等於num的數不等於num -> 4 -> 代表4有重複 
 * 
 * 因為小於等於x的個數為遞增函數, 所以可以使用binary search
 * 
 * Time complexity: O(NlogN)
 * Space complexity: O(1)
 */

class Solution {
    public int findDuplicate(int[] nums) {
        int low = 1, high = nums.length - 1; // 最大就是nums.length - 1
        int duplicate = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int count = count(nums, mid);
            if (count > mid) {
                high = mid - 1;
                duplicate = mid;
            } else {
                low = mid + 1;
            }
        }
        return duplicate;
    }
    
    // 計算 <= x的數字共有幾個
    private int count(int[] nums, int x) {
        int count = 0;
        for (int num : nums) {
            if (num <= x) count++;
        }
        return count;
    }
}