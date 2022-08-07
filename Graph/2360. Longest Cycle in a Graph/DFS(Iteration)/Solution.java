/**
 * Run DFS, 每次run都用map紀錄，起點到該點的距離，
 * 當發現再visit一次時，即發現cycle，cycle length = d - 前一次的d
 *
 *
 * 參考:https://www.youtube.com/watch?v=vc_kz2M-jw4&ab_channel=CodewithAlisha 
 * Time complexity: O(N)
 * Space complexity: O(N)
 *
 */
class Solution {
    
    private int max = -1;
    
    public int longestCycle(int[] edges) {
        int n = edges.length;
        boolean[] marked = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!marked[i]) {
                dfs(edges, i, marked);
            }
        }
        return max;
    }
    
    private void dfs(int[] edges, int start, boolean[] marked) {
        HashMap<Integer, Integer> distanceMap = new HashMap<>();
        int i = start;
        int d = 0;
        while (i != -1) {
            if (!marked[i]) {
                marked[i] = true;
                distanceMap.put(i, d);
            } else if (distanceMap.containsKey(i)) {
                max = Math.max(max, d - distanceMap.get(i));
                return;
            } else { // 發現visited過, 直接return
                return;
            }
            d++;
            i = edges[i];
        }
    }
}