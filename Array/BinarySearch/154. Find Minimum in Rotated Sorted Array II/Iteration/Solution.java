/**
 * Iteration version (不好寫, 很多小細節, 很容易寫錯)
 * (與153不同的點在於，當發現nums[mid] == nums[hi]時, 只能hi--(一個一個去檢查), 所以worse case變成O(N))
 * 
 * 1.為什麼nums[mid] < nums[hi] 時是hi = mid, 但else卻是 lo = mid + 1
 * 原因: 因為包含了兩種可能, (1)代表右邊是sorted, 最小值發生在左邊, 此時確實只需要hi = mid - 1
 *                        (2)nums[mid]剛好就是最小值, 這時就如果只用hi = mid - 1, 就直接把最小值砍掉了, 解法就是要hi = mid
 *      反之else的話, 因為mid不可能是最小值, 所以直接用lo = mid + 1就可以了
 * 
 * 2.為什麼要nums[mid] < nums[hi], 而不能用nums[mid] > nums[lo]?
 * 原因: 因為他rotate是往右邊移動, 所以nums[mid] < nums[hi]才能得到右邊是sorted,而左邊不是
 *      而單從nums[mid] > nums[lo], 無法推得左邊是sorted而右邊不是(考慮rotate == 0的情況)
 * 
 * 
 * 
I'm confused why we should use ```nums[mid] < nums[hi]``` instead of ```nums[mid] > nums[lo]```
Here is my thought:
The reason why we should use ```nums[mid] < nums[hi]``` instead of ```nums[mid] > nums[lo]``` is because the rotatation is going right. 
So we can deduce the ```Inflection Point``` is happened at left from ```nums[mid] < nums[hi]```. 
But from  ```nums[mid] > nums[lo]``` we can't deduce the ```Inflection Point``` is happened at right.

Am I right??
 *
 * Time complexity: O(N)
 * Space complexity: O(1)
 *
 */
class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < nums[hi]) { // Inflection Point在左半部
                hi = mid;
            } else if (nums[mid] > nums[hi]) { // Inflection Point在右半部
                lo = mid + 1;
            } else if (nums[hi - 1] > nums[hi]){ // cut off, if nums[mid] == nums[hi] we need to hi--, but we can check wheteher we already find Inflection Point
                lo = hi;
                break;
            } else {
                hi--;
            }
        }
        return nums[lo];
    }
}