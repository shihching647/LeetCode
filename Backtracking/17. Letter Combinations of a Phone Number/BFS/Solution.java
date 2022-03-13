/**
 * BFS
 * 
 * Time complexity: O(4 ^ n)
 * Space complexity: O(4 ^ n)
 *
 */
class Solution {

    private Map<Character, String> mapping;
    
    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        if (n == 0)
            return new ArrayList<>();
        init();
        LinkedList<String> result = new LinkedList<>();
        result.add("");
        while (result.peek().length() != digits.length()) { // 當result的長度 == digits的長度 -> 中止
            int i = result.peek().length();
            String str = result.removeFirst();
            for (char c : mapping.get(digits.charAt(i)).toCharArray())
                result.add(str + c);
        }
        return result;
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