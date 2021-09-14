/**
 * Reservoir sampling: 從n個選k個, 每個數字都有 k / n的機率被選中.
 * (Knuth’s method: 每讀到第i個Node, 有 1 / i的機率選中此Node)
 * 
 * 好處: 1. 不需要額外空間儲存元素
 *       2. 給一stream of 元素, 在任何時間都可以擁有相同機率取得之前出現過的元素.
 * Time complexity: Constructor: O(1), getRandom: O(N)
 * Space complexity: O(1)
 */

class Solution {

    private ListNode head;
    private Random rand;
    
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
        rand = new Random();
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        // Knuth’s method: 每讀到第i個Node, 有 1 / i的機率選中此Node
        int i = 1;
        ListNode cur = head;
        ListNode ans = null;
        while (cur != null) {
            boolean choose = random(1.0 / i++);
            if (choose) {
                ans = cur;
            }
            cur = cur.next;
        }
        return ans.val;
    }
    
    // 有p的機率return true, 1 - p的機率回傳false (rand.nextDobule() 回傳 [0, 1)之間的double)
    private boolean random(double p) {
        return rand.nextDouble() < p;
    }
}
