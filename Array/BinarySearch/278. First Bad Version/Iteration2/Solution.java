/**
 * Iteration version
 * 找到第一個F的位置(同153的Iteration2), 用一個ans紀錄F的位置, 持續找到最好的
 *
 * Time complexity: O(logN)
 * Space complexity: O(1)
 *
 */
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int lo = 0, hi = n;
        int ans = n;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (isBadVersion(mid)) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }
}