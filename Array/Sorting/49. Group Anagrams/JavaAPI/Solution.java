/**
 * 使用Java sort
 * 
 * Time complexity: O(N*MlogM) (M : max(strs[i].length))
 * Space complexity: O(N)
 */

class Solution {
    
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> bucket = new HashMap<>();
        for (String str : strs) {
            char[] strArray = str.toCharArray();
            Arrays.sort(strArray);
            String key = new String(strArray);
            List<String> list = bucket.getOrDefault(key, new LinkedList<>());
            list.add(str);
            bucket.put(key, list);
        }
        return new LinkedList<>(bucket.values());
    }

}