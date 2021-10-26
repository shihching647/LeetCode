/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

/**
 * 取ops的交集, 最後直接maxX * maxY
 * 
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        if (ops.length == 0)
            return m * n;
        
        int maxX = Integer.MAX_VALUE;
        int maxY = Integer.MAX_VALUE;
        for (int i = 0; i < ops.length; i++) {
            maxX = Math.min(ops[i][0], maxX);
            maxY = Math.min(ops[i][1], maxY);
        }
        return maxX * maxY;
    }
    
}
