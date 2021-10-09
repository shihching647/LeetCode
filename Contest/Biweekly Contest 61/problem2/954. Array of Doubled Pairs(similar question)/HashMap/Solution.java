/**
 * 解題重點: "絕對值"最小的那個數一定不會是乘於2之後的數字裡面.
 * 
 * 
 * Time complexity: O(NlogN)
 * Space complexity: O(K) (K個不同的數字)
 *
 */
class Solution {
    public boolean canReorderDoubled(int[] arr) {
        
        HashMap<Integer, Integer> countMap = new HashMap<>();
        Integer[] temp = new Integer[arr.length]; // 因為Arrays.sort()必須要是Intger[].
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            temp[i] = num;
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        // 照絕對值排
        Arrays.sort(temp, Comparator.comparingInt(Math::abs));
        
        for (int num : temp) {
            int count = countMap.get(num);
            if (count == 0) continue;
            if (countMap.getOrDefault(2 * num, 0) <= 0)
                return false;
            countMap.put(num, --count);
            countMap.put(2 * num, countMap.get(2 * num) - 1);
        }
        
        return true;
    }
}