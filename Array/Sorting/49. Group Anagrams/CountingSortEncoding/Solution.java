/**
 * 使用Counting sort的概念. 將count[] array當做key來分bucket
 * 
 * Time complexity: O(N * M) (M : max(strs[i].length))
 * Space complexity: O(N)
 */

class Solution {
    
    private static final int R = 26;
    
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> bucket = new HashMap<>();
        for (String str : strs) {
            char[] strArray = str.toCharArray();
            String key = new String(encode(strArray));
            List<String> list = bucket.getOrDefault(key, new LinkedList<>());
            list.add(str);
            bucket.put(key, list);
        }
        return new LinkedList<>(bucket.values());
    }
    
    // 因為0 <= strs[i].length <= 100, 所以可以用char來記錄出現的次數
    private char[] encode(char[] a) {
        char[] count = new char[R];
        for (int i = 0; i < a.length; i++)
            count[a[i] - 'a']++;
        return count;
    }
}