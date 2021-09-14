/**
 * Brute Force: 把每一個salary都當作base試試看, 算出以他為基底, 得到的最小的total wage.
 *  
 * Time complexity: O(N^2logN)
 * Space complexity: O(N)
 */
class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        double minWage = Double.POSITIVE_INFINITY;
        for (int base = 0; base < n; base++) {
            PriorityQueue<Double> pq = new PriorityQueue<>();
            for (int j = 0; j < n; j++) {
                double salary = ((quality[j] * 1.0) / quality[base]) * wage[base];
                if (salary >= wage[j])
                    pq.offer(salary);
            }
            if (pq.size() >= k) {
                double totalWage = 0.0;
                for (int i = 0; i < k; i++) {
                    totalWage += pq.poll();
                }
                minWage = Math.min(minWage, totalWage);
            }
        }
        return minWage;
    }
}