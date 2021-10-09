/**
 * 解題重點: "絕對值"最小的那個數一定不會是乘於2之後的數字裡面.
 * 用TreeMap的話, 負數是由絕對值大到小(所以要找除2的值), 正數事由絕對值小到大(所以要找乘2的值)
 * 
 * 
 * Time complexity: O(NlogK) (K個不同的數字)
 * Space complexity: O(K) (K個不同的數字)
 *
 */
class Solution {
    public boolean canReorderDoubled(int[] arr) {
        
        TreeMap<Integer, Integer> countMap = new TreeMap<>();
        
        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
                
        for (int num : countMap.keySet()) {
            int count = countMap.get(num);
            if (count == 0) continue;
            // 負數找除2的值, 正數找乘2的值
            int find = num < 0 ? num / 2 : 2 * num;
            // 負的要多檢查 num 是否為2的倍數
            if (num < 0 && num % 2 != 0 || countMap.getOrDefault(find, 0) < count)
                return false;
            countMap.put(find, countMap.get(find) - count);
        }
        
        return true;
    }
}