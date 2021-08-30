/**
 * Use two pointer find the two sum,
 * iterate all elements find the two index. 
 * 
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum > target) j--;
            else if (sum < target) i++;
            else return new int[]{i + 1, j + 1};
        }
        throw new IllegalArgumentException("No solution are found");
    }
}