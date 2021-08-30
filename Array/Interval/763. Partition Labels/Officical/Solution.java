/**
 * 先把每個字母尋一遍找出每個字母最大的位置存入last中,
 * 第二輪iteration時候, 遇到每個字母c, 由last找出該字母最後出現的位置,
 * 再去與curMax取大的(換句話說:curMax存的數字為在preMax~i之間出現過的所有字母中, 最後一次出現的位置)
 * 若當curMax == i, 表示此時preMax~i之間出現過的字母都已經被包圍住, 故此時的位置即為答案之一
 * 將(preMax ~ curMax)長度加入result, 並更新preMax
 * 
 * 參考:https://leetcode.com/problems/partition-labels/discuss/899214/2-solutions-(explanation-%2B-picture)
 * 
 * Time complexity: O(n)
 * Space complexity: O(1) (因為last.length()最大就是26)
 */
class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        
        int preMax = 0, curMax = 0;
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            curMax = Math.max(curMax, last[s.charAt(i) - 'a']);
            if (curMax == i) {
                result.add(curMax - preMax + 1);
                preMax = curMax + 1;
            }
        }
        return result;
    }
}