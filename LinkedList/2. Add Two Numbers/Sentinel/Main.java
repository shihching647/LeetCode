
/**
 *  Time complexity: O(Max(n, m))
 *  Space complexity: O(Max(n,m) + 1)
 */
public class Main {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode(0); // use a sentinel to avoid conditional expression
        ListNode current = sentinel;
        int sum = 0;
        while (l1 != null || l2 != null) {
            sum /= 10;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            current.next = new ListNode(sum % 10); // avoid one variable as carry
            current = current.next;
        }
        // remember another carry
        if (sum / 10 == 1)
            current.next = new ListNode(1, null); // avoid one variable as carry
        return sentinel.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3, null)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4, null)));
        ListNode node = addTwoNumbers(l1, l2); // [7,0,8]
        System.out.println(node);

        ListNode l3 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, null))));
        ListNode l4 = new ListNode(9, new ListNode(9, null));
        node = addTwoNumbers(l3, l4);
        System.out.println(node);  //[8,9,0,0,1]
        node = addTwoNumbers(l4,l3);
        System.out.println(node); //[8,9,0,0,1]

        node = addTwoNumbers(null, l4);
        System.out.println(node);  //[9,9]

        ListNode l5 = new ListNode(9, new ListNode(9, null));
        ListNode l6 = new ListNode(1, null);
        node = addTwoNumbers(l5, l6);
        System.out.println(node); // [1,0,0]
    }
}
