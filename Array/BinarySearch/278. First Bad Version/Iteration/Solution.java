/**
 * Iteration version
 * 找到第一個F的位置(同153的Iteration2), 用一個ans紀錄F的位置, 持續找到最好的
 * 
 * 可輕鬆簡化成另一個版本:
 * 把19行ans = mid拿掉, 20行改成hi = mid, 回傳hi, 改成while(lo < hi)(不用背, 用想的, 主要是要避免落入無窮迴圈)
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