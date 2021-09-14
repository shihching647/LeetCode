/**
 * 將nums排序, 計算每一個數字出現的次數, 當超過 n / 3時加到result
 *
 * Time complexity: O(NlogN)
 * Space complexity: O(1)
 */

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<Integer> result = new LinkedList<>();
        int count = 0;
        int num = nums[0];
        for (int x : nums) {
            if (num == x) count++;
            else {
                if (count > n / 3){
                    result.add(num);
                }
                num = x;
                count = 1;
            }
        }
        if (count > n / 3) 
            result.add(num);
        
        return result;
    }
}