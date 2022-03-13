/**
 * 沒有使用任何Java API
 * 1. reverse whole string
 * 2. reverse each word(不好寫): 使用two pointer, i ~ j框住 
 * 3. cleanSpaces: 使用two pointer, i為最後處理過String的長度, j用來掃過未處理的String
 * 
 * 
 * Time complexity: O(N)
 * Space complexity: O(N)
 *
 */
class Solution {
    public String reverseWords(String s) {
        char[] a = s.toCharArray();
        // 1. reverse whole string
        reverse(a, 0, a.length - 1);
        // 2. reverse each word
        reverseWord(a);
        // 3. clean space
        return cleanSpaces(a);
    }
    
    private void reverse(char[] a, int start, int end) {
        int i = start, j = end;
        while (i < j) {
            char temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }
    }
    
    private void reverseWord(char[] a) {
        int n = a.length;
        int i = 0, j = 0;
        while (i < n) {
            i = j; //make i and j equal (j might be ahead as it might have seen a word before)
            while (i < n && a[i] == ' ') i++; // skip spaces
            
            j = i; //make j and i equal (i might be ahead as it found few spaces). 此時i為word的頭
            while (j < n && a[j] != ' ') j++; // skip non spaces
            reverse(a, i, j - 1);
        }
        
        // 另一種寫法
        // while (i < n) {
        //     while (i < j || i < n && a[i] == ' ') i++; // skip spaces
        //     while (j < i || j < n && a[j] != ' ') j++; // skip non spaces
        //     reverse(a, i, j - 1);                      // reverse the word
        // }        
    }
    
    // trim leading, trailing and multiple spaces
    // 需要兩行重複的while (j < n && a[j] == ' ') j++; 是為了處理tail有包含1個以上的空白的case
    private String cleanSpaces(char[] a) {
        int n = a.length;
        int i = 0, j = 0;
        while (j < n) {
            while (j < n && a[j] == ' ') j++; // skip spaces
            while (j < n && a[j] != ' ') a[i++] = a[j++]; // 發現words, 回填到i的位置
            while (j < n && a[j] == ' ') j++; // skip spaces
            if (j < n) a[i++] = ' '; // 有下一個字, 所以補一個空白
        }
        char[] result = new char[i];
        System.arraycopy(a, 0, result, 0, i);
        return new String(result);
    }
}