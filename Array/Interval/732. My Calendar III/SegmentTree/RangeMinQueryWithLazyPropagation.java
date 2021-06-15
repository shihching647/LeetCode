/**
 * Lazy Propagation Segment Tree
 * 參考影片：https://www.youtube.com/watch?v=xuoQdt5pHj0&ab_channel=TusharRoy-CodingMadeSimple
 */

import java.util.Arrays;

public class RangeMinQueryWithLazyPropagation {

    private int[] input;
    private int[] segmentTree;
    private int[] lazyTree;

    public RangeMinQueryWithLazyPropagation(int input[]) {
        int n = input.length;
        this.input = input.clone();
        segmentTree = new int[2 * n - 1]; // 若n是2的次方, segmentTree開 n * 2 - 1, 若不是, 則開 (大於n的下一個2的次方數) * 2 - 1
        Arrays.fill(segmentTree, Integer.MAX_VALUE);
        lazyTree = new int[segmentTree.length];
        Arrays.fill(lazyTree, 0);
        constructTree(input, 0, n - 1, 0);
    }

    private void constructTree(int[] input, int lo, int hi, int pos) {
        if (lo == hi) {
            segmentTree[pos] = input[lo];
            return;
        }
        int left = 2 * pos + 1;
        int right = 2 * pos + 2;
        int mid = (lo + hi) / 2;
        constructTree(input, lo, mid, left);
        constructTree(input, mid + 1, hi, right);
        segmentTree[pos] = Math.min(segmentTree[left], segmentTree[right]); // parent node為min(left, right)
    }

    public void updateSegmentTreeLazy(int start, int end, int delta) {
        updateSegmentTreeLazy(start, end, delta, 0, input.length - 1, 0);
    }

    private void updateSegmentTreeLazy(int start, int end, int delta, int lo, int hi, int pos) {
        if (lo > hi) return;

        int left = 2 * pos + 1;
        int right = 2 * pos + 2;

        // 先完成lazyTree裡未更新的內容, 然後再傳給left, right
        if (lazyTree[pos] != 0) {
            updateLazyTree(lo, hi, pos);
        }

        // no overlap
        if (end < lo || start > hi) {
            return;
        }

        // total overlap
        if (start <= lo && end >= hi) {
            segmentTree[pos] += delta;
            if (lo != hi) { // 不是left node
                lazyTree[left] += delta;
                lazyTree[right] += delta;
            }
            return;
        }

        // partial overlap
        int mid = (left + right) / 2;
        updateSegmentTreeLazy(start, end, delta, lo, mid, left);
        updateSegmentTreeLazy(start, end, delta, mid + 1, hi, right);

        // update segmentTree
        segmentTree[pos] = Math.min(segmentTree[left], segmentTree[right]);
    }

    // 先完成lazyTree裡未更新的內容, 然後再傳給left, right
    private void updateLazyTree(int lo, int hi, int pos) {
        int left = 2 * pos + 1;
        int right = 2 * pos + 2;
        segmentTree[pos] += lazyTree[pos];
        if (lo != hi) { // 不是left node
            lazyTree[left] += lazyTree[pos];
            lazyTree[right] += lazyTree[pos];
        }
        lazyTree[pos] = 0;
    }

    public int minRangeQuery(int lo, int hi) {
        if (hi < lo) throw new IllegalArgumentException("hi is smaller than lo");
        return minRangeQuery(lo,  hi, 0, input.length - 1,0);
    }

    // 與RangeMinQuery相同, 差別只在於要更新lazyTree
    private int minRangeQuery(int queryLo, int queryHi, int lo, int hi, int pos) {
        if (lo > hi)
            return Integer.MAX_VALUE;

        // 先完成lazyTree裡未更新的內容, 然後再傳給left, right
        if (lazyTree[pos] != 0) {
            updateLazyTree(lo, hi, pos);
        }

        // total overlap
        if (queryLo <= lo && queryHi >= hi) {
            return segmentTree[pos];
        }
        // no overlap
        if (queryHi < lo || queryLo > hi) {
            return Integer.MAX_VALUE;
        }
        // partial overlap
        int mid = (lo + hi) / 2;
        int left = 2 * pos + 1;
        int right = 2 * pos + 2;
        return Math.min(minRangeQuery(queryLo, queryHi, lo, mid, left), minRangeQuery(queryLo, queryHi, mid + 1, hi, right));
    }

    public static void main(String[] args) {
        RangeMinQueryWithLazyPropagation tree = new RangeMinQueryWithLazyPropagation(new int[]{-1,2,4,0});
        tree.updateSegmentTreeLazy(0, 3, 5);
        System.out.println(tree.minRangeQuery(1, 3));
    }
}
