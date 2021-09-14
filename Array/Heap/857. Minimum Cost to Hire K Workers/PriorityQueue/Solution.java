/**
 * 想法:
 * 先把worker照ratio(單位quality所需的wage)由小到大排序, 再依序以ratio當作base算出最小的miniWage
 * (為什麼要由小到大排列: 為了滿足Every worker in the paid group must be paid at least their minimum wage expectation. 所以要取k個工人裡面, ratio最大的那一個當作base)
 *
 * 算minWage時候只需要維持一個sumQuality, miniWage = sumQuality * worker.ratio().
 * 每次iterate一個woker, 因為ratio都會上升, 所以sumQuality要下降, 所以就剔除quantity最大的那個值, 這樣sumQuality才會下降最多.
 *  
 * 參考: https://www.youtube.com/watch?v=3a_HFrdpjos&ab_channel=M.C%E7%B1%B3%E5%BC%80%E6%9C%97%E5%9F%BA%E7%BD%97
 * Time complexity: O(NlogN)
 * Space complexity: O(N)
 */
class Solution {
    
    private static class Worker implements Comparable<Worker> {
        private int quality;
        private int wage;
        
        private Worker (int quality, int wage) {
            this.quality = quality;
            this.wage = wage;
        }
        
        // 越低代表愈划算(單位quality所需的wage)
        private double ratio() {
            return (wage * 1.0) / quality; 
        }
        
        public int compareTo(Worker other) {
            return Double.compare(this.ratio(), other.ratio());
        }
    }
    
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = wage.length;
        Worker[] workers = new Worker[n];
        for (int i = 0; i < n; i++) {
            workers[i] = new Worker(quality[i], wage[i]);
        }
        Arrays.sort(workers);
        
        double minWage = Double.POSITIVE_INFINITY;
        int sumQuality = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> n2 - n1); 
        for (Worker worker : workers) {
            pq.offer(worker.quality);
            sumQuality += worker.quality;
            if (pq.size() == k) {
                minWage = Math.min(minWage, sumQuality * worker.ratio()); // sumQuality * worker.ratio()為minWage
                sumQuality -= pq.poll(); // 剔除qualitity最大的那一個
            }
        }
        return minWage;
    }
}