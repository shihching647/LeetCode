/**
 * Two pointer, 檢查是否為母音用indexOf()
 * Time complexity: O(n)
 * Space complexity: O(1)
 *
 */
class Solution {
    static final String vowels = "aeiouAEIOU";
    
    public String reverseVowels(String s) {
        char[] array = s.toCharArray();
        int i = 0, j = array.length - 1;
        while (i < j) {
            while (!isVowel(array[i]) && i < j) i++;
            while (!isVowel(array[j]) && i < j) j--;
            if (i >= j) break;
            char temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
        return new String(array);
    }
    
    private boolean isVowel(char c) {
        return vowels.indexOf(c) != -1;
    }
}