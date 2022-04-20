/**
 * 使用 HashMap: 紀錄每個元素的index位置
 *         +     
 *       list: 紀錄所有元素  
 * 實作:
 * insert() : 將元素加入list, 並將位置紀錄在indexMap裡
 * remove() : 將要移除的元素與最後一個元素位置調換, 並移除最後一個元素
 * 
 * 參考: https://www.youtube.com/watch?v=y240Qh9H9uk
 * Time complexity: O(1)
 * Space complexity: O(N)
 */
class RandomizedSet {
    
    private HashMap<Integer, Integer> indexMap;
    private List<Integer> list;
    private Random rand;
    
    public RandomizedSet() {
        indexMap = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if (indexMap.containsKey(val)) {
            return false;
        } else {
            indexMap.put(val, list.size());
            list.add(list.size(), val);
            return true;
        }
    }
    
    public boolean remove(int val) {
        if (indexMap.containsKey(val)) {
            int index = indexMap.remove(val);
            if (index != list.size() - 1) {
                // 把最後一個元素換到index的位置
                int lastValue = list.get(list.size() - 1);
                list.set(index, lastValue);
                indexMap.put(lastValue, index);
            }
            // 移除最後一個
            list.remove(list.size() - 1);
            return true;
        } else {
            return false;
        }
    }
    
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */