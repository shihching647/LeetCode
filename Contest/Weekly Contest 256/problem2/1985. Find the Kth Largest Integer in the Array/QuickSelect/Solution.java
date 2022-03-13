/**
 * 使用qucik select.
 *
 * Time complexity: O(N)
 * Space complexity: O(1)
 */
class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int j = partition(nums, l, r); // 大 -> 小
            if (j == k - 1) {
                return nums[j];
            } else if (j > k - 1) {
                r = j - 1;
            } else {
                l = j + 1;
            }
        }
        return nums[r];
    }
    
    private int partition(String[] nums, int l, int r) {
        int pivotIndex = l + (int) (Math.random() * (r - l + 1));
        swap(nums, l, pivotIndex);
        String pivot = nums[l];
        int i = l, j = r + 1;
        while (true) {
            while (greater(nums[++i], pivot)) {
                if (i == r) break;
            }
            while (greater(pivot, nums[--j])) {
                if (j == l) break;
            }
            if (i >= j)
                break;
            swap(nums, i, j);
        }
        swap(nums, j, l); // 與l換!! 這個每次都忘記!!
        return j;
    }
    
    private boolean greater(String s1, String s2) {
        if (s1.length() == s2.length()) {
            return s1.compareTo(s2) > 0;
        }
        return s1.length() > s2.length();
    }
    
    private void swap(String[] nums, int i, int j) {
        String temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}