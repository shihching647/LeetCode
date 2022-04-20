/**
 * 使用 HashMap: key: 元素val, value: 一個Set, 紀錄元素的所有index位置
 *         +     
 *       list: 紀錄所有元素  
 * 實作:
 * insert() : 將元素加入list, 並將位置紀錄在indexSetMap對應的set裡
 * remove() : 將要移除的元素與最後一個元素位置調換(對應的set都要更新index), 並移除最後一個元素
 * 
 * 參考: https://www.youtube.com/watch?v=mRTgft9sBhA
 * Time complexity: O(1)
 * Space complexity: O(N)
 */
class RandomizedCollection {

    private Random rand = new Random();
    private HashMap<Integer, HashSet<Integer>> indexSetMap;
    private List<Integer> list;
    
    public RandomizedCollection() {
        indexSetMap = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if (!indexSetMap.containsKey(val)) {
            indexSetMap.put(val, new HashSet<>());
        }
        indexSetMap.get(val).add(list.size());
        list.add(val);
        return indexSetMap.get(val).size() == 1;
    }
    
    public boolean remove(int val) {
        if (!indexSetMap.containsKey(val) || indexSetMap.get(val).size() == 0) {
            return false;
        }
        // 先將index從val的indexSet中移除
        HashSet<Integer> set = indexSetMap.get(val);
        int index = set.iterator().next(); // set.iterator()為O(1)
        set.remove(index);
        // 將最後一個元素移動到index
        int lastValue = list.get(list.size() - 1);
        list.set(index, lastValue);
        // 更新對應的set (必須先加才移除, 否則當lastValue跟val為一樣的時候會有問題)
        HashSet<Integer> lastSet = indexSetMap.get(lastValue);
        lastSet.add(index);
        lastSet.remove(list.size() - 1);
        // 移除最後一個元素
        list.remove(list.size() - 1);
        return true;
    }
    
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */