/**
 * 
 * Time complexity: O(N)
 * Space complexity: O(N)
 *
 */
class Solution {
    public String reversePrefix(String word, char ch) {
        char[] a = word.toCharArray();
        int end = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == ch) {
                end = i;
                break;
            }
        }
        if (end >= 0) {
            reverse(a, 0, end);
        }
        return new String(a);
    }
    
    public void reverse(char[] a, int start, int end) {
        int i = start, j = end;
        while (i < j) {
            char temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }
    }
}