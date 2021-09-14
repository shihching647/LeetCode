/**
 * HashMap
 * 
 * Time complexity: Constructor: O(n), getRandom: O(1)
 * Space complexity: O(n)
 */

class Solution {

    private Map<Integer, ListNode> map;
    
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        map = new HashMap<>();
        int i = 0;
        while (head != null) {
            map.put(i++, head);
            head = head.next;
        }
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        return map.get((int)(Math.random() * map.size())).val;
    }
}