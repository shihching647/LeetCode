/**
 * 此問題等於在求: (同142. Linked List Cycle II)
 * Given a linked list, return the node where the cycle begins.
 * 
 * Time complexity: O(N)
 * Space complexity: O(1)
 */

class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                slow = 0;
                while (slow != fast) {
                    slow = nums[slow];
                    fast = nums[fast];
                }
            }
        } while (slow != fast);
        return slow;
    }
}