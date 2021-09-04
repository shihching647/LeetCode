/**
 * 使用Priority Queue取出下一個node
 * 
 * Time complexity: O(NlogK) (K為lists的長度)
 * Space complexity: O(K) (因為pq裡面最多就是K個元素)
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((n1, n2) -> n1.val - n2.val);
        for (ListNode x : lists) {
            if (x != null) // special case: lists包含null
                pq.offer(x);
        }
        ListNode sentinel = new ListNode(0);
        ListNode cur = sentinel;
        while (!pq.isEmpty()) {
            ListNode x = pq.poll();
            cur.next = x;
            cur = cur.next;
            if (x.next != null)
                pq.offer(x.next);
        }
        return sentinel.next;
    }
}