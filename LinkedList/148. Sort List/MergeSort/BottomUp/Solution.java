/**
 * Bottom-up merge sort
 * Time complexity: O(nlogn)
 * Space complexity: O(1)
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
    ListNode sortedList;  // sortedList的尾巴
    ListNode nextSubList; // 下一個subList的頭
    
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        int len = getLength(head);
        
        ListNode sentinel = new ListNode();
        ListNode start = head;
        for (int size = 1; size < len; size *= 2) {
            sortedList = sentinel;
            while (start != null) {
                // 剩下最後一個node, 不用split了, 直接接到sortedList後面
                if (start.next == null) {
                    sortedList.next = start;
                    break;
                }
                ListNode sencondHead = split(start, size);
                merge(start, sencondHead);
                start = nextSubList;
            }
            start = sentinel.next;
        }
        return sentinel.next;
    }
    
    /**
     * 從start開始, 將長度為 2 * size 的List分成為兩個長度為size的sub list, 並回傳第二個list的head
     * @param start start node
     * @param size  length of sub list
     * @return start of the second list
     */
    private ListNode split(ListNode start, int size) {
        ListNode p = start;
        ListNode end = p.next;
        
        // 困難！！！
        for (int index = 1; index < size && (p.next != null || end.next != null); index++) {
            if (p.next != null) {
                p = p.next;
            }
            if (end.next != null) {
                end = end.next.next != null ? end.next.next : end.next;
            }
        }
        
        ListNode secondHead = p.next;
        p.next = null;
        nextSubList = end.next; // 更新下一個list的頭
        end.next = null;
        return secondHead;
    }
    
    private void merge(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode();
        ListNode p = sentinel;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        // 連接剩下的list
        p.next = (l1 != null) ? l1 : l2;
        
        // 要記錄目前sortedList到哪, 所以要走到最後面
        while (p.next != null) {
            p = p.next;
        }
        sortedList.next = sentinel.next; //連接之前的sortedList的尾巴與目前的list
        sortedList = p; // 更新sortedList的尾巴到目前list的尾巴
    }
    
    private int getLength(ListNode head) {
        int size = 0;
        while (head != null) {
            head = head.next;
            size++;
        }
        return size;
    }
}