/**
 * 解題重點: 最小的那個數一定會在original array裡面.
 * 先記錄每個數字出現幾次. 再把changed[]排序. 
 * 再iterate排序過後的changed[](一定要由小到大, 避免把加到乘於2後的數字)
 * 
 * Time complexity: O(NlogN)
 * Space complexity: O(K) (original array裡不同的數字的個數K)
 *
 */
class Solution {
    public int[] findOriginalArray(int[] changed) {
        if (changed.length <= 1 || changed.length % 2 != 0)
            return new int[0];
        
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < changed.length; i++) {
            countMap.put(changed[i], countMap.getOrDefault(changed[i], 0) + 1);
        }
        
        Arrays.sort(changed);
        int[] result = new int[changed.length / 2];
        int j = 0;
        for (int num : changed) {
            if (countMap.get(num) == 0) 
                continue;
            if (countMap.getOrDefault(2 * num, 0) <= 0)
                return new int[0];
            countMap.put(num, countMap.get(num) - 1);
            countMap.put(2 * num, countMap.get(2 * num) - 1);
            result[j++] = num;
        }
        return result;
    }
}