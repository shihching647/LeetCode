/**
 * 參考: https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/discuss/78551/7-lines-Easy-Java-Solution
 * 影片: https://www.youtube.com/watch?v=_mbnPPHJmTQ&ab_channel=SamShen
 * 
 * dif = inDegree - outDegree
 * 一開始dif = 1(代表可放置一個root), 從左到右scan
 * 每讀一個字母, dif - 1, 表示消耗一個array, 如果dif < 0(代表後面的此字母沒地方可以放) return false,
 * 若不為#, dif += 2
 *  
 * Time complexity: O(N)
 * Space complexity: O(1) 
 *
 */
class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] tokens = preorder.split(",");
        int dif = 1; 
        for (String c : tokens) {
            if (--dif < 0) return false;
            if (!c.equals("#")) dif += 2;
        }
        return dif == 0;
    }
}