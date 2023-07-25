/**
 * Binary search
 * 
 * Time complexity: O(logN)
 * Space complexity: O(1)
 *
 */
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            boolean leftLessThanMid = arr[mid - 1] < arr[mid];
            boolean midLessThanRight = arr[mid] < arr[mid + 1];
            if (leftLessThanMid && !midLessThanRight) { // find the peak
                return mid;
            } else if (leftLessThanMid && midLessThanRight) { // arr[left] < arr[mid] < arr[right] => pick right
                left = mid + 1;
            } else { // pick left
                right = mid;
            }
        }
        throw new IllegalArgumentException("Not a mountain array!");
    }
}