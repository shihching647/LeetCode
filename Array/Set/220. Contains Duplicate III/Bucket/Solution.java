/**
 * 把在window內的元素依照value化成不同的index分為不同的bucket.(使用map存)
 * 若nums[i]在同一個bucket已經有元素 -> 代表滿足題目條件 -> return true
 * 不然就是檢查鄰近的bucket看是否差值介於 t 之間(只有鄰近的有可能 <= t)
 * 
 * index mappping方法：
 * 以t == 2為例, 將元素以每 w = 3 = t + 1個分為一個bucket, 例子如下
 
 i   i/w  index
-5  -1    -2
-4  -1    -2
-3  -1    -1
-2   0    -1
-1   0    -1
 0   0     0
 1   0     0
 2   0     0
 3   1     1
 4   1     1
 5   1     1

 *
 * Time complexity: O(N)
 * Space complexity: O(K)
 */

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        HashMap<Integer, Long> map = new HashMap<>(); // value要用Long(因為差值可能大於Integer的上限)
        int w = t + 1;
        for (int i = 0; i < nums.length; i++) {
            // 該元素的index: m
            int m = index(nums[i], w);
            // 若i > k, 要移除window第一個元素
            if (i > k)
                map.remove(index(nums[i - k - 1], w));
            // 檢查是否已經有元素存在
            if (map.containsKey(m)) {
                return true;
            }
            // 檢查鄰近的元素
            if (map.containsKey(m - 1) && nums[i] - map.get(m - 1) <= t)
                return true;
            if (map.containsKey(m + 1) && map.get(m + 1) - nums[i] <= t)
                return true;
            // 將該元素加入window中
            map.put(m, (long) nums[i]);
        }
        return false;
    }
    
    // 給一個num, 算出對應的bukcet編號
    private int index(int num, int w) {
        return num < 0 ? (num + 1) / w - 1 : num / w; 
    }
}