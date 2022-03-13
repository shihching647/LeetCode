/**
 * 使用bit的差來計算duplicate
 * 如: nums = [3,1,3,2,4] (有5個elements, 所以n = 4與base[] = [1,2,3,4]比較)
 * 計算base[]的bit和 -> baseCount: [0,0,1] + [0,1,0] + [0,1,1] + [1,0,0] = [1,2,2]
 * 計算nums[]的bit和 -> numsCount: [0,1,1] + [0,0,1] + [0,1,1] + [0,1,0] + [1,0,0] = [1,3,3]
 * 兩個差 numsCount[] - baseCount[] = [0,1,1] -> 3是重複的 (只需考慮減完後大於0的bit]
 * 
 * 
 * Time complexity: O(NlogN)
 * Space complexity: O(1)
 */
class Solution {
    public int findDuplicate(int[] nums) {
        int duplicate = 0;
        int n = nums.length - 1;
        int maxBit = findMaxBitCount(n); // 最大的數字有幾個bit
        
        for (int bit = 0; bit < maxBit; bit++) { // maxBit 正比於 log2(N)
            int mask = 1 << bit;
            int baseCount = 0, numsCount = 0;
            
            for (int i = 0; i <= n; i++) {
                if ((i & mask) > 0) { // (i & mask) 代表該位置的bit為1
                    baseCount++;
                }
                if ((nums[i] & mask) > 0) {
                    numsCount++;
                }
            }
            
            if (numsCount > baseCount) { // 大於0的話prepend到duplicate
                duplicate |= mask;
            }
        }
        return duplicate;
    }
    
    private int findMaxBitCount(int num) {
        int bits = 0;
        while (num > 0) {
            num /= 2;
            bits++;
        }
        return bits;
    }
}