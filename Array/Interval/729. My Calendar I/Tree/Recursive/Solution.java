/**
 * 用tree存整個calendar
 * Time complexity: O(n) (insert n times)
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
    private boolean result;

    public MyCalendar() {

    }

    public boolean book(int start, int end) {
        result = false;
        root = put(root, start, end);
        return result;
    }

    private Node put(Node x, int start, int end) {
        if (x == null) {
            result = true;
            return new Node(start, end);
        }
        if (isOverlap(new int[]{start, end}, new int[]{x.start, x.end})) {
            result = false;
            return x;
        }
        int comp = Integer.compare(start, x.start);
        if (comp < 0) x.left = put(x.left, start, end);
        else x.right = put(x.right, start, end);
        return x;
    }

    private boolean isOverlap(int[] interval1, int[] interval2) {
        int[][] intervals = new int[][] {interval1, interval2};
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        if (intervals[0][1] <= intervals[1][0]) return false;
        return true;
    }
}