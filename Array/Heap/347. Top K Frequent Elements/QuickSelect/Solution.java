/**
 * 先統計每個num出現的頻率, 將每個unique的數字放入array中,
 * 在使用quick select選出第k個最常出現的數字 (比大小時使用出現的頻率比(從map中取得))
 * 
 * Time complexity: average O(n) 
 * Space complexity: O(n)
 */

class Solution {
    
    private HashMap<Integer, Integer> map;
    private int[] unique;
    
    public int[] topKFrequent(int[] nums, int k) {
        map = new HashMap<>();
        for (int x : nums) {
            int count = map.getOrDefault(x, 0);
            map.put(x, ++count);
        }
        
        int n = map.size();
        unique = new int[n];
        int i = 0;
        for (int key : map.keySet()) {
            unique[i++] = key;
        }
        
        int index = quickSelect(0, n - 1, k);
        return Arrays.copyOfRange(unique, 0, index + 1); // 複製[0, index + 1)的元素
    }
    
    private int quickSelect(int lo, int hi, int k) {
        int rank = k - 1; // 這邊k是1時, 為第一個元素, 所以rank是0
        while (lo < hi) {
            int j = partition(lo, hi);
            if (j == rank) return rank; // 這邊要回傳index所以是return rank
            else if (j < rank) lo = j + 1;
            else hi = j - 1;
        }
        return lo; // 回傳index
    }
    
    private int partition(int lo, int hi) {
        int pivotIndex = lo + (int) (Math.random() * (hi - lo + 1));
        swap(lo, pivotIndex); // 交換lo, pivotIndex
        int i = lo;
        int j = hi + 1;
        while (true) {
            while (greater(++i, lo)) { // 這時候lo才是pivot, 因為已經把lo, pivotIndex交換了
                if (i == hi) break;
            }
            
            while (greater(lo, --j)) {
                if (j == lo) break;
            }
            if (i >= j)
                break;
            swap(i, j);
        }
        swap(lo, j); // 把lo, pivotIndex換回來
        return j;
    }
    
    // 比較unique[i]與unique[j]出現的次數
    private boolean greater(int i, int j) {
        return map.get(unique[i]) > map.get(unique[j]);
    }
    
    private void swap(int i, int j) {
        int temp = unique[i];
        unique[i] = unique[j];
        unique[j] = temp;
    }
}