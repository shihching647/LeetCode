/**
 * 注意: 這個方法會改到nums裡面的元素
 * 
 * 使用index與nums[index]相同作為出現過的代表.
 * 因為數字在[1, n]內, 所以從0開始(因為0不可能為重複的元素).
 * 下一個數字就是nums[0]本來的那個數. 以此追蹤下去.
 * 
 * Time complexity: O(N)
 * Space complexity: O(1)
 */
class Solution {
    public int findDuplicate(int[] nums) {
        int temp = nums[0];
        while (temp != nums[temp]) {
            int next = nums[temp];
            nums[temp] = temp;
            temp = next;
        }
        return temp;
    }
}