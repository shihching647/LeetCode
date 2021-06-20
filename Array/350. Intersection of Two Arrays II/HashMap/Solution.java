/**
 * Use a map.
 * Time complexity: O(n + m)
 * Space complexity: O(n + m)
 *
 * 
 * Follow up:
 * What if elements of nums2 are stored on disk, and the memory is limited
 * such that you cannot load all elements into the memory at once?
 *
 * If only nums2 cannot fit in memory, put all elements of nums1 into a HashMap, 
 * read chunks of array that fit into the memory, and record the intersections.
 * 
 * If both nums1 and nums2 are so huge that neither fit into the memory, sort them individually (external sort),
 * then read 2 elements from each array at a time in memory, record intersections.
 * 
 * External sort:
 * Sorting data when all of th data dosen't fit into RAM.
 * Meger sort is an efficient external sort.
 * https://www.youtube.com/watch?v=Bp7fGofslng
 */

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums1) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        int k = 0;
        for (int n : nums2) {
            int count = map.getOrDefault(n, 0);
            if (count > 0) {
                nums1[k++] = n;
                map.put(n, --count);
            }
        }
        
        return Arrays.copyOf(nums1, k);
    }
}