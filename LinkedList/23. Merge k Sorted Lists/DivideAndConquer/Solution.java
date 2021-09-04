/**
 * Divide and conquer : 兩兩合併 (寫法要練習)
 * 
 * Time complexity: O(NlogK) (K為lists的長度)
 * Space complexity: O(1)
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        // 兩兩合併
        int interval = 1;
        int n = lists.length;
        while (interval < n) {
            for (int i = 0; i + interval < n; i += interval * 2) {
                lists[i] = mergeTwoList(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }
        return lists[0];
    }
    
    private ListNode mergeTwoList(ListNode leftNode, ListNode rightNode) { 
        ListNode sentinel = new ListNode(0);
        ListNode cur = sentinel;
        while (leftNode != null && rightNode != null) {
            if (leftNode.val < rightNode.val) {
                cur.next = leftNode;
                leftNode = leftNode.next;
            } else {
                cur.next = rightNode;
                rightNode = rightNode.next;
            }
            cur = cur.next;
        }
        // 這邊要注意！！ 跟array不一樣, 只需要把尾巴直接接到leftNode or rightNode就好！！ 
        // 每次都寫成while那種, 不需要！！
        if (leftNode != null)
            cur.next = leftNode;
        if (rightNode != null)
            cur.next = rightNode;
        return sentinel.next;
    }
}