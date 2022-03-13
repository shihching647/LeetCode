/**
 * 題意: 兩個排好序的nums, 各取一個數字, 找出前k個和最小的組合.
 * 1.暴力法: 找出所有組合nums1[i], nums2[j], 再排序(n * m)
 * 2.利用PriorityQueue且nums1, nums2已經排序好的性質:
 * 先固定一組nums2[0]一個數字, 將他與nums1所有數字的組合加入倒PQ裡面, 並在後面多標示一個index == 0(表示這是nums2的index).
 * 移除PQ k次, 每次移除一個element, 並把他的下一個與nums2的組合加入.(因為下一組的是此固定nums1元素與nums2最小的組合)
 * 
 * 
 * Time complexity: O(KlogN) (N = max(nums1.length, nums2.length))
 * Space complexity: O(K)
 */

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> wrap = new ArrayList<>(k);
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a1, a2) -> ((a1[0] + a1[1]) - (a2[0] + a2[1]))
        );
        
        for(int num : nums1) {
            pq.add(new int[] {num, nums2[0], 0}); // 最後一個元素使用來表示目前num1這個元素對應的nums2的哪一個index
        }
        
        while (k > 0 && !pq.isEmpty()) {
            int[] nextPair = pq.poll();
            wrap.add(Arrays.asList(nextPair[0], nextPair[1]));
            int nextNum2Index = nextPair[2];
            if (nextNum2Index < nums2.length - 1) { 
                pq.offer(new int[] {nextPair[0], nums2[nextNum2Index + 1], nextNum2Index + 1}); // nums1的元素不動, nums2的位置+1
            }
            k--;
        }
        
        return wrap;
    }
}