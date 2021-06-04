/**
 * Binary Search:
 * 用window的大小去做binary search(與一般的用法不同), 找到最小的範圍
 * Time complexity: O(nlogn)
 * Space complexity: O(1)
 */
public class Solution {

    public int minSubArrayLen(int target, int[] nums) {
        int minLength = 0;
        int i = 1, j = nums.length; // 此處的i, j是window的size, 用size去做binary search, 所以 i 從1開始, j從nums.length開始
        while (i <= j) {
            int mid = (i + j) / 2;
            if (windowCheck(mid, nums, target)) {
                minLength = mid;
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return minLength;
    }

    /**
     * 回傳nums陣列內, 在size的範圍(window)內的連續整數字和是否有大於size的可能
     * @param size window的size
     * @param nums 欲檢查的陣列
     * @param target 目標值
     * @return 有或沒有
     */
    private boolean windowCheck(int size, int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i >= size) sum -= nums[i - size]; // 當i超過size時，須先減去window內最前面的數字
            sum += nums[i];
            if (sum >= target) return true; // 找到就馬上回傳, 由呼叫的binary search去做size更小的嘗試
        }
        return false;
    }
}