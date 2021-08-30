/**
 * For each numbers[i], use binary search find target - numbers[i]
 * 
 * Time complexity: O(nlogn)
 * Space complexity: O(1)
 */
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            // binarySearch(int[] a, int fromIndex, int toIndex, int key)
            // fromIndex - the index of the first element (inclusive) to be searched
            // toIndex - the index of the last element (exclusive) to be searched
            int j = Arrays.binarySearch(numbers, i + 1, numbers.length, target - numbers[i]);
            if (j >= 0) {
                return new int[] {i + 1, j + 1};
            }
        }
        throw new IllegalArgumentException("No solutions are found.");
    }
}