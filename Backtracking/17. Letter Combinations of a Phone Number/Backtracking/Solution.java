/**
 * Backtracking
 * 
 * Time complexity: O(4 ^ n)
 * Space complexity: O(4 ^ n)
 *
 */
class Solution {
    private Map<Character, String> mapping;
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return new ArrayList<>();
        init();
        List<String> result = new ArrayList<>();
        combine(0, digits, new StringBuilder(), result);
        return result;
    }
    
    private void combine(int index, String digits, StringBuilder sb, List<String> result) {
        int n = digits.length();
        if (sb.length() == n) {
            result.add(sb.toString());
            return;
        }
        String characters = mapping.get(digits.charAt(index));
        for (int i = 0; i < characters.length(); i++) {
            sb.append(characters.charAt(i));
            combine(index + 1, digits, sb, result);
            sb.deleteCharAt(index);
        }
        return;
    }
    
    private void init() {
        mapping = new HashMap<>();
        mapping.put('2', "abc");
        mapping.put('3', "def");
        mapping.put('4', "ghi");
        mapping.put('5', "jkl");
        mapping.put('6', "mno");
        mapping.put('7', "pqrs");
        mapping.put('8', "tuv");
        mapping.put('9', "wxyz");
    }
}