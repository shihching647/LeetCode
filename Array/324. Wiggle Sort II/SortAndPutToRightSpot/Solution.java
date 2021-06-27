/**
 * 先用temp存排序好的nums, 再將元素放置在對的位置
 * 放的方式: 
 * 先找到中位數M, 將數字分為S(小於M), L(大於M)
 * 將小的數由最大到最小(由右至左)(M->S)填入偶數位置
 * 將大的數由最大到最小(由右至左)(L->M)填入奇數位置
 * (由右至左的原因：
 *  Consider the case "SMML":
 *  由右至左 ->  MLSM
 *  由左至右 ->  SMML (錯誤)
 * )
 * 
 *  Small half:  M . S . S . S      Small half:  M . S . S . S .
 *  Large half:  . L . L . M .      Large half:  . L . L . L . M
 *  --------------------------      --------------------------
 *  Together:    M L S L S M S      Together:    M L S L S L S M
 * 
 * 便可得到答案
 * 
 * 參考:https://leetcode.com/problems/wiggle-sort-ii/discuss/77678/3-lines-Python-with-Explanation-Proof
 * 
 * 
 * Time complexity: O(nlogn)
 * Space complexity: O(n)
 */

class Solution {
    public void wiggleSort(int[] nums) {
        if (nums.length < 2)
            return;

        int[] temp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(temp);
        int n = nums.length;

        int small = (n + 1) / 2 - 1; // median位置, 小的那最右邊的那個位置
        int large = n - 1;           // 大的那群最右邊的位置
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                nums[i] = temp[small--];
            } else {
                nums[i] = temp[large--];
            }
        }
        
    }
}