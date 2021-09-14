/**
 * 對頻率做sorting
 *  
 * Time complexity: O(NlogN)
 * Space complexity: O(N)
 */
class Solution {
    private class Node {
        int num;
        int count;
        
        public Node(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }
    
    public int[] topKFrequent(int[] nums, int k) {
        // 先計算每個數字出現的頻率
        HashMap<Integer, Node> map = new HashMap<>();
        for (int x : nums) {
            Node node = map.getOrDefault(x, new Node(x, 0));
            node.count++;
            map.put(x, node);
        }
        
        // 在對頻率排序
        List<Node> list = new ArrayList<>(map.values());
        list.sort((n1, n2) -> Integer.compare(n2.count, n1.count));
        
        // 取出前K個element
        int[] result = new int[k];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i).num;
        }
        return result;
    }
}