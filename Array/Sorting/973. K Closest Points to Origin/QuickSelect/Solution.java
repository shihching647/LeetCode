/**
 * 使用Quick select, 找到第k個位置, 在K左邊的都是比K小的
 * 
 * Time complexity: O(N)
 * Space complexity: O(K)
 */

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int lo = 0, hi = points.length - 1;
        while (lo < hi) {
            int j = partition(points, lo, hi);
            if (j < k) lo = j + 1;
            else if (j > k) hi = j - 1;
            else break;
        }
        return Arrays.copyOf(points, k);
    }
    
    private int partition(int[][] a, int lo, int hi) {
        int pivot = lo + (int) (Math.random() * (hi - lo + 1));
        swap(a, lo, pivot);
        int i = lo, j = hi + 1;
        while (true) {
            while (less(a[++i], a[lo])) {
                if (i == hi) break;
            }
            
            while (less(a[lo], a[--j])) {
                if (j == lo) break;
            }
            
            if (i >= j) {
                break;
            }
            swap(a, i, j);
        }
        swap(a, lo, j);
        return j;
    }
    
    private void swap(int[][] a, int i, int j) {
        int[] temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    private boolean less(int[] a, int[] b) {
        return a[0] * a[0] + a[1] * a[1] < b[0] * b[0] + b[1] * b[1];
    }
}