/**
 * Collections.reverse(), Arrays.asList(String[] a)
 *
 * Time complexity: O(N)
 * Space complexity: O(N)
 *
 */
class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words)); // 這邊reverse list, 原來的words也會被revese
        return String.join(" ", words);
    }
}