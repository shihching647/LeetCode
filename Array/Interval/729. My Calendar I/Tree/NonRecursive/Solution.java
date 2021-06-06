/**
 * 用tree存整個calendar
 * Time complexity: O(nlogn) (insert n times)
 * Space complexity: O(n)
 */
class MyCalendar {
    private class Node {
        private int start, end;
        private Node left, right;

        public Node (int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private Node root;

    public MyCalendar() {

    }

    public boolean book(int start, int end) {
        Node newNode = new Node(start, end);
        if (root == null) {
            root = newNode;
            return true;
        }
        Node parent = null, x = root;
        while (x != null) {
            parent = x;
            if (isOverlap(new int[]{start, end}, new int[]{x.start, x.end}))
                return false;
            int comp = Integer.compare(start, x.start);
            if (comp < 0) x = x.left;
            else x = x.right;
        }
        if (start < parent.start) parent.left = newNode;
        else parent.right = newNode;
        return true;
    }

    private boolean isOverlap(int[] interval1, int[] interval2) {
        int[][] intervals = new int[][] {interval1, interval2};
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        if (intervals[0][1] <= intervals[1][0]) return false;
        return true;
    }
}