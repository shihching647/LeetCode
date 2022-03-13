/**
 * Step1: 先將parents[]轉成HashMap儲存parent -> left,right
 * Step2: 找到值為1的那個node
 * Step3: 從1那個node開始, 先往下做dfs(visit()為把Node的值加到set裡面), 再找取得以此node為root的subTree最小缺的正整數.
 *        下一回再往parent做dfs. (記錄此node為pre, 下一回iteration做dfs時可以略過此node)
 *
 * 參考: https://www.youtube.com/watch?v=in_qO4nOsqA&ab_channel=HappyCoding
 * Time complexity: O(N)
 * Space complexity: O(N)
 */

/**
 * 重點: 
 * 1. 每個node的value都是distinct的
 * 2. 只有包含1的subTree才需要更新reuslt, 其他不包含1的subTree的結果都是1
 * 3. traverse用parent[]表示的Tree, 需要用一個HashMap<Integer, List<Integer>>來存每個node的left index和right index
 * 4. 用一個max來代表目前缺的最小正整數. 因為max只會往上加(因為是從1那個node往上找ancestor, 所以ancestor一定包含之前的node, 故max只會越來越大)
 * 5. cut off: 前一個visit過的node要記錄下一次不用visit
 */
class Solution {
    
    HashMap<Integer, List<Integer>> tree = new HashMap<>();
    HashSet<Integer> set = new HashSet<>(); // 用來存出現過的數字(用set的原因是:每個node的value都是distinct的)
    int max = 1; // 用來追蹤目前缺少的最小數字
    
    public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        int n = nums.length;
        
        // construct tree
        for (int i = 0; i < n; i++) {
            // List<Integer> list = tree.getOrDefault(parents[i], new ArrayList<>());
            // list.add(i);
            // tree.put(parents[i], list);
            tree.computeIfAbsent(parent[i], k->new ArrayList<>()).add(i); 
        }
        
        int[] result = new int[n];
        Arrays.fill(result, 1);
        // find 1's node, 那個node為start node
        int start = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                start = i;
                break;
            }
        }
        
        // speical case
        if (start < 0) {
            return result;
        }
        
        int pre = -1; // 記錄前一個visit的node
        while (start != -1) { // start == -1代表到了root了
            // 往start為root, 往下做dfs
            List<Integer> children = tree.get(start);
            if (children != null) {
                for (int child : children) {
                    if (child == pre) continue; // 因為是從下往上visit, 前一個處理過的child不需要再處理.
                    dfs(child, nums);
                }
            }
            set.add(nums[start]); // visit過此node
            // 找到目前缺的最小的數
            while (set.contains(max)) {
                max++;
            }
            result[start] = max; // 填入result
            pre = start;
            start = parents[start];
        }
        
        return result;
    }
    
    private void dfs(int node, int nums[]) {
        set.add(nums[node]); // visit過此node
        List<Integer> children = tree.get(node);
        if (children != null) {
            for (int child : children) { // 這裡是有上而下做dfs所以沒有重複的問題, 下面都是沒有visit過的
                dfs(child, nums);
            }
        }
    }
    
}