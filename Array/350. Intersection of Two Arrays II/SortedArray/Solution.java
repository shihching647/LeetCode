/**
 * If arrays are sorted
 * Time complexity: O(n + m)
 * Space complexity: O(1)
 */

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // assume arrays are dorted
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                nums1[k++] = nums1[i];
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        
        return Arrays.copyOf(nums1, k);
    }
}