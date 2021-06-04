import java.util.Stack;

/**
 *  Iterate through all elements and remember the tail of left part
 *  and use a stack to store the middle part which will be reserved.
 *  When reverse the middle part, remember the head of right part.
 *  Edge cases:
 *      1. left equals to 1
 *      2. left == right
 *      3. length of list equals to 1
 *
 *
 *  Time complexity: O(n)
 *  Space complexity: O(right - left + 1) (which is the size of stack)
 */
public class Main {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right || head == null || head.next == null)
            return head;
        int n = 1;
        ListNode p = head;
        ListNode leftPart = null; // 記著leftPart的尾巴
        Stack<ListNode> stack = new Stack<>();
        while (p != null) {
            if (n == left - 1) leftPart = p;
            if (n >= left && n <= right) {
                stack.push(p);
            }
            n++;
            p = p.next;
        }

        // reverse the middle part
        ListNode reverseList = stack.pop(); // middle part head
        ListNode rightPart = reverseList.next; // 記著rightPart的開頭
        p = reverseList;
        while (!stack.empty()) {
            p.next = stack.pop();
            p = p.next;
        }

        // concatenate the middle part and right part
        p.next = rightPart;

        if (leftPart == null) { // case left == 1
            head = reverseList;
        } else {
            leftPart.next = reverseList;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        ListNode reverse = reverseBetween(l1, 1, 5);
        System.out.println(reverse);
    }
}
