/**
 * 使用Java API : PriorityQueue(屬於minQueue)(記住Comparator的用法)
 *  
 * Time complexity: O(NlogN)
 * Space complexity: O(N)
 */
class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int x : nums) {
            int count = countMap.getOrDefault(x, 0);
            countMap.put(x, ++count);
        }
        
        // 建立Priority Queue(minQueue), insert K個element, insert時用頻率比較
        PriorityQueue<Integer> pq = new PriorityQueue<>((e1, e2) -> countMap.get(e1) - countMap.get(e2));
        for (int key : countMap.keySet()) {
            pq.offer(key);
            if (pq.size() == k + 1) // 當size超過k時, 移除掉出現最少的那一個
                pq.poll();
        }
        
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.remove();
        }
        return result;
    }
}