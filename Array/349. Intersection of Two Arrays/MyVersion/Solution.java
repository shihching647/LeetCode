/**
 * Use two set
 * Time complexity: O(n + m)
 * Space complexity: O(n + m)
 */

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        for (int n : nums1) 
            set1.add(n);
        
        HashSet<Integer> set2 = new HashSet<>();
        for (int n : nums2) {
            if (set1.contains(n)) {
                set2.add(n);
            }
        }
        
        int[] result = set2.stream().mapToInt(i -> i).toArray();

        /* 另外的方法 (LeetCode跑起來較快)
         * int[] result = new int[set2.size()];
         * int i = 0;
         * for (int n : set2) {
         *     result[i++] = n;
         * }
         */
        return result;
    }
}