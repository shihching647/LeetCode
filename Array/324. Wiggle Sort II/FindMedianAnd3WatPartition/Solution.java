/**
 * 先用quicl select找到median
 * 在用3-way partiton操作在newIndex
 * (newIndex是將奇數為放在左側, 偶數位放在右側, median放在中間)
 * 
 * 參考:https://leetcode.com/problems/wiggle-sort-ii/discuss/77682/Step-by-step-explanation-of-index-mapping-in-Java
 * 
 * 
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int median = findKthLargest(nums, (n + 1) / 2);

        // 3-way partition using newIndex
        int i = 0;
        int le = 0, gt = n - 1;
        while (i <= gt) {
            if (nums[newIndex(i, n)] > median) {        // 大的在左邊(newIndex左邊為奇數)
                swap(nums, newIndex(i++, n), newIndex(le++, n));
            } else if (nums[newIndex(i, n)] < median) { // 小的在右邊(newIndex右邊為偶數)
                swap(nums, newIndex(i, n), newIndex(gt--, n));
            } else {                                    // 中間都是median的位置
                i++;
            }
        }
    }

    /**
     *  Original index   :   0    1    2    3    4    5  
     *  new index        :   1    3    5    0    2    4 
     *  (1,3,5為小於medain的位置, 2,4為大於median的位置)
     */
    private int newIndex(int i, int n) {
        return (2 * i + 1) % (n|1);
    }

    /** (解釋newIndex方法: https://leetcode.com/problems/wiggle-sort-ii/discuss/77682/Step-by-step-explanation-of-index-mapping-in-Java)
    
    This is to explain why mapped index formula is (1 + 2*index) % (n | 1)

    Notice that by placing the median in it's place in the array we divided the array in 3 chunks: all numbers less than median are in one side, all numbers larger than median are on the other side, median is in the dead center of the array.

    We want to place any a group of numbers (larger than median) in odd slots, and another group of numbers (smaller than median) in even slots. So all numbers on left of the median < n / 2 should be in odd slots, all numbers on right of the median > n / 2 should go into even slots (remember that median is its correct place at n / 2)

    PS: I'm ignoring the discussion of odd/even array length for simplicity.

    So let's think about the first group in the odd slots, all numbers is the left side of the array should go into these odd slots. What's the formula for it? Naturally it would be:
    (1 + 2 x index) % n

    All these indexes are less than n / 2 so multiplying by 2 and add 1 (to make them go to odd place) and then mod by n will always guarantee that they are less than n.

    Original Index => Mapped Index
    0 => (1 + 2 x 0) % 6 = 1 % 6 = 1
    1 => (1 + 2 x 1) % 6 = 3 % 6 = 3
    2 => (1 + 2 x 2) % 6 = 5 % 6 = 5

    These are what's less than median, if we continue this with indexes 3, 4, 5 we will cycle again:
    3 => (1 + 2 x 3) % 6 = 7 % 6 = 1
    4 => (1 + 2 x 4) % 6 = 9 % 6 = 3
    5 => (1 + 2 x 5) % 6 = 11 % 6 = 5

    and we don't want that, so for indexes larger than n/2 we want them to be even, (n|1) does that exactly. What n|1 does it that it gets the next odd number to n if it was even
    if n = 6 for example 110 | 1 = 111 = 7
    if n = 7 for example 111 | 1 = 111 = 7

    and this is what we want, instead of cycling the odd numbers again we want them to be even, and odd % odd number is even so updating the formula to :
    (1 + 2*index) % (n | 1)

    Then we have:
    3 => (1 + 2 x 3) % 7 = 7 % 7 = 0
    4 => (1 + 2 x 4) % 7 = 9 % 7 = 2
    5 => (1 + 2 x 5) % 7 = 11 % 7 = 4
     */

    // LeetCode 215. Kth Largest Element in an Array (quick select)    
    private int findKthLargest(int[] nums, int k) {
        int lo = 0, hi = nums.length - 1;
        int rank = k - 1;
        while (hi > lo) {
            int j = partition(nums, lo, hi);
            if (rank < j) hi = j - 1;
            else if (rank > j) lo = j + 1;
            else return nums[j];
        }
        return nums[lo];
    }
    
    private int partition(int[] nums, int lo, int hi) {
        // randomly choose pivot
        int pivotIndex = lo + (int) (Math.random() * (hi - lo + 1));
        swap(nums, lo, pivotIndex);
        int pivot = nums[lo];
        int i = lo;
        int j = hi + 1;
        
        while (true) {
            while (nums[++i] > pivot) {
                if (i == hi) break;
            }
            while (nums[--j] < pivot) {
                if(j == lo) break;
            }
            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, lo, j);
        return j;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}