/**
 * Bucket Sort:
 * 先統計每個num出現幾次, 在對統計後的結果針對freq做bucket sort
 *  
 * Time complexity: O(N)
 * Space complexity: O(N)
 */
class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        int maxCount = 0; // 這邊要統計出現最高的頻率是多少次, 才能知道bucket[]的大小
        for (int x : nums) {
            int count = countMap.getOrDefault(x, 0);
            maxCount = Math.max(maxCount, ++count);
            countMap.put(x, count);
        }
        
        // 對freuency做bucket sort
        List<Integer>[] bucket = new LinkedList[maxCount + 1];
        for (int key : countMap.keySet()) {
            int freq = countMap.get(key);
            if (bucket[freq] == null) {
                bucket[freq] = new LinkedList<>();
            }
            bucket[freq].add(key);
        }
        
        // 從後往前加入最高頻出現的數字
        int[] result = new int[k];
        int j = 0;
        for (int i = bucket.length - 1; i >= 1; i--) {
            if (bucket[i] != null) {
                for (int num : bucket[i]) {
                    result[j++] = num;
                }
                if (j == k) break;
            }
        }
        return result;
    }
}