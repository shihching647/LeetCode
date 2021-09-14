/**
 * Boyer-Moore Voting Algorithm
 * 想法: 每個元素都投票給該數字, 最終majority的count一定會大於0
 * 實作: 統計count, 當元素相等時count + 1, 不同時count - 1, 當count被扣到為0時, 將majority換成當前元素, 留下來的一定是majority
 *
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int c1 = 0, c2 = 0;
        int count1 = 0, count2 = 0;
        for (int x : nums) {
            if (x == c1) {
                count1++;
            } else if (x == c2) {
                count2++;
            } else if (count1 == 0) {
                c1 = x;
                count1 = 1;
            } else if (count2 == 0) {
                c2 = x;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int x : nums) {
            if (x == c1) count1++;
            else if (x == c2) count2++;
        }
        List<Integer> result = new ArrayList<>();
        if (count1 > nums.length / 3) result.add(c1);
        if (count2 > nums.length / 3) result.add(c2);
        return result;
    }
}