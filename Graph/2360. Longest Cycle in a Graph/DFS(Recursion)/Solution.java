/**
 * Run DFS, 每次run都用map紀錄，起點到該點的距離，
 * 當發現再visit一次時，即發現cycle，cycle length = d - 前一次的d
 * (distanceMap一定要用HashMap, 用array的話會TLE, 不知道為什麼)
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
                dfs(edges, i, marked, new HashMap<>(), 0);
            }
        }
        return max;
    }
    
    private void dfs(int[] edges, int i, boolean[] marked, HashMap<Integer, Integer> distanceMap, int d) {
        marked[i] = true;
        if (edges[i] != -1) {
            if (!marked[edges[i]]) {
                distanceMap.put(i, d);
                dfs(edges, edges[i], marked, distanceMap, d + 1);
            } else if (distanceMap.containsKey(edges[i])) {
                max = Math.max(max, d - distanceMap.get(edges[i]) + 1);
            }
        }
    }
}