/**
 * 使用Priority queue, <分數, index>, 從分數最小的開始填, 填的時候檢查左右兩邊是否已經填且分數不同, 已經填就再加一
 * Time complextiy : O(nlogn)
 * Space complexity: O(n)
 */

import java.util.*;

class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        // Use a priority queue, rating as key, index as value
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.getKey()));
        
        // add entry to priority queue, and keep a candy array to tracking candies
        int[] candy = new int[n];
        for (int i = 0; i < n; i++) {
            pq.add(new AbstractMap.SimpleEntry<>(ratings[i],i));
            candy[i] = 0; // initial to 0
        }
        
        int ans = 0;
        while (!pq.isEmpty()) {
            Map.Entry<Integer,Integer> e = pq.remove();
            int rating = e.getKey();
            int index = e.getValue();
            int count = 1; // candy count
            int right = index + 1, left = index - 1;
            // candy[right] is filled && ratings[right] != rating
            if (right < n && candy[right] > 0 && ratings[right] != rating) {
                count = candy[right] + 1;
            }
            // candy[left] is filled && ratings[left] != rating
            if (left >= 0 && candy[left] > 0 && ratings[left] != rating) {
                count = Math.max(count, candy[left] + 1);
            }
            // filled candy[index]
            candy[index] = count;
            // add to answer
            ans += count;
        }
        
        return ans;
    }
}