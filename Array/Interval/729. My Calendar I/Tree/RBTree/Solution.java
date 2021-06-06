/**
 * 用Red-Black Tree存整個calendar
 * Time complexity: O(logn) (insert n times)
 * Space complexity: O(n)
 */
class MyCalendar {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    
    private class Node {
        private int start, end;
        private Node left, right;
        private boolean color;

        public Node (int start, int end, boolean color) {
            this.start = start;
            this.end = end;
            this.color = color;
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

    private Node put(Node h, int start, int end) {
        if (h == null) {
            result = true;
            return new Node(start, end, RED);
        }
        if (isOverlap(new int[]{start, end}, new int[]{h.start, h.end})) {
            result = false;
            return h;
        }
        int comp = Integer.compare(start, h.start);
        if (comp < 0) h.left = put(h.left, start, end);
        else h.right = put(h.right, start, end);
        
        if (!isRed(h.left) && isRed(h.right)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColors(h);
        
        return h;
    }
    
    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private void flipColors(Node h) {
        h.right.color = BLACK;
        h.left.color = BLACK;
        h.color = RED;
    }
    
    private boolean isRed(Node x) {
        if (x == null) return false;
        return x.color;
    }

    private boolean isOverlap(int[] interval1, int[] interval2) {
        int[][] intervals = new int[][] {interval1, interval2};
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        if (intervals[0][1] <= intervals[1][0]) return false;
        return true;
    }
}