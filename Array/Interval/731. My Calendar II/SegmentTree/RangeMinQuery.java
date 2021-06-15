/**
 * Segment Tree
 * 參考影片：https://www.youtube.com/watch?v=ZBHKZF5w4YU&ab_channel=TusharRoy-CodingMadeSimple
 */

import java.util.Arrays;

public class RangeMinQuery {

    /**
     * 使用array來表示tree, root在0的位置
     * left : 2 * pos + 1
     * right : 2 * pos + 2
     * parent : (pos - 1) / 2
     */
    private int[] input;
    private int[] segmentTree;

    public RangeMinQuery(int[] input) {
        int n = input.length;
        this.input = input.clone();
        segmentTree = new int[2 * n - 1]; // 若n是2的次方, segmentTree開 n * 2 - 1, 若不是, 則開 (大於n的下一個2的次方數) * 2 - 1
        Arrays.fill(segmentTree, Integer.MAX_VALUE);
        constructTree(input, 0, n - 1, 0);
    }

    private void constructTree(int[] input, int lo, int hi, int pos) {
        if (lo == hi) {
            segmentTree[pos] = input[lo]; // left node為input[lo]
            return;
        }
        int mid = (lo + hi) / 2;
        int left = 2 * pos + 1;
        int right = 2 * pos + 2;
        constructTree(input, lo, mid, left);
        constructTree(input, mid + 1, hi, right);
        segmentTree[pos] = Math.min(segmentTree[left], segmentTree[right]); // parent node為min(left, right)
    }

    public int minRangeQuery(int lo, int hi) {
        if (hi < lo) throw new IllegalArgumentException("hi is smaller than lo");
        return minRangeQuery(lo,  hi, 0, input.length - 1,0);
    }

    private int minRangeQuery(int queryLo, int queryHi, int lo, int hi, int pos) {
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
        RangeMinQuery tree = new RangeMinQuery(new int[]{-1,2,4,0});
        System.out.println(tree.minRangeQuery(1,1));
    }
}
