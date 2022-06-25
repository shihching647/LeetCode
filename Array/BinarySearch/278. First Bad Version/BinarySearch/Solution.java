/**
 * Binary Search
 * Time complexity: O(logN)
 * Space complexity: O(1)
 *
 */
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid))
                right = mid - 1;
            else
                left = mid + 1;
        }
        return left;
    }
}