/**
 * 使用Counting sort
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
            sort(strArray);
            String key = new String(strArray);
            List<String> list = bucket.getOrDefault(key, new LinkedList<>());
            list.add(str);
            bucket.put(key, list);
        }
        return new LinkedList<>(bucket.values());
    }
    
    private void sort(char[] a) {
        char[] aux = new char[a.length];
        int[] count = new int[R + 1];
        for (int i = 0; i < a.length; i++)
            count[a[i] - 'a' + 1]++;
        
        for (int c = 0; c < R; c++)
            count[c + 1] += count[c];
        
        for (int i = 0; i < a.length; i++)
            aux[count[a[i] - 'a']++] = a[i];
        
        System.arraycopy(aux, 0, a, 0, a.length);
    }
}