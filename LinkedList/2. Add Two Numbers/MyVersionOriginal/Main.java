
public class Main {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode sumList = new ListNode(0, null);
        ListNode current = sumList;
        // 長度一樣
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            carry = checkCarry(current, sum);
            l1 = l1.next;
            l2 = l2.next;
            if (l1 != null || l2 != null || carry != 0)
                current.next = new ListNode(carry, null);
            current = current.next;
        }

        // l1比較長
        while (l1 != null) {
            carry = checkCarry(current, current.val + l1.val);
            if (l1.next != null || carry != 0) {
                current.next = new ListNode(carry, null);
                current = current.next;
            }
            l1 = l1.next;
        }

        // l2比較長
        while (l2 != null) {
            carry = checkCarry(current, current.val + l2.val);
            if (l2.next != null || carry != 0) {
                current.next = new ListNode(carry, null);
                current = current.next;
            }
            l2 = l2.next;
        }

        return sumList;
    }

    private static int checkCarry(ListNode node, int sum) {
        if (sum > 9) {
            sum -= 10;
            node.val = sum;
            return 1;
        } else {
            node.val = sum;
            return 0;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3, null)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4, null)));
        ListNode node = addTwoNumbers(l1, l2);
        System.out.println(node);
        ListNode l3 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, null))));
        ListNode l4 = new ListNode(9, new ListNode(9, null));
        node = addTwoNumbers(l3, l4);
        System.out.println(node);  //[8,9,0,0,1]
    }
}
