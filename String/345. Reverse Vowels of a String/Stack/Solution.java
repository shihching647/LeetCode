/**
 * 使用Stack, 判別為母音用switch case
 * Time complexity: O(n)
 * Space complexity: O(n)
 *
 */
class Solution {
    public String reverseVowels(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (isVowel(c)) stack.push(c);
        }
        
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (isVowel(c)) sb.append(stack.pop());
            else sb.append(c);
        }
        return sb.toString();
    }
    
    private boolean isVowel(char c) {
        switch (c) {
            case 'a': case 'e': case 'i': case 'o': case 'u':
            case 'A': case 'E': case 'I': case 'O': case 'U':
                return true;
        }
        return false;
    }
}