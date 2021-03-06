/**
 * Boyer-Moore Voting Algorithm
 * 想法: 因為majority number > n / 3, 所以最多只會有兩個, 最少0個. 
 * 實作: 分別記錄最多次的元素(c1)和第二多次的元素(c2), 和他的的count數(count1, count2).
 *       Iterate整個陣列, 遇到相同的元素對應的count++, 不同的元素兩者都要-1.
 *      (因為數量 > n / 3, 所以若出現兩個mahority number, count1, count2最後必定會 > 0(因為其他的元素必定會小於 n / 3))
 * 
 * 實做重點: 1.一開始不需要指定c1和c2, 當count1, count2某一個為0的時候在將其替換掉就好.
 *          2. 第一個迴圈與第二個迴圈都要用if... else if ... (因為有可能全部都是一樣的元素, 避免加入result兩次) 
 *          3. 最後需要再跑一次迴圈確認數量是否大於 n / 3. (c1, c2並不代表一定有解, 只代表有解的話一定為c1和c2)
 *
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int c1 = 0, c2 = 0;
        int count1 = 0, count2 = 0;
        for (int x : nums) {
            if (x == c1) {
                count1++;
            } else if (x == c2) {
                count2++;
            } else if (count1 == 0) {
                c1 = x;
                count1 = 1;
            } else if (count2 == 0) {
                c2 = x;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        // 再跑一次迴圈確認是否為majority number
        count1 = 0;
        count2 = 0;
        for (int x : nums) {
            if (x == c1) count1++;
            else if (x == c2) count2++;
        }
        List<Integer> result = new ArrayList<>();
        if (count1 > nums.length / 3) result.add(c1);
        if (count2 > nums.length / 3) result.add(c2);
        return result;
    }
}