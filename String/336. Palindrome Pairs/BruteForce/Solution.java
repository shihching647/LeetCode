/**
 * Brute Force
 * Time complexity: O(N^2)
 * Space complexity: O(1)
 *
 */
class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> wrap = new LinkedList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                StringBuilder sb = new StringBuilder();
                if (i != j && isPalindrome(sb.append(words[i]).append(words[j])))
                    wrap.add(Arrays.asList(new Integer[]{i, j}));
            }
        }
        return wrap;
    }
    
    private boolean isPalindrome(StringBuilder s) {
        if (s.length() <= 1)
            return true;
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}