/**
 * 使用HashMap: (參考: https://www.youtube.com/watch?v=XpxCzLl61lU&ab_channel=IntutingStudio)
 * 
 * 1. 先掃過整個words一次, 並使用HashMap紀錄每個字的reverse和index, 並將是palindrome的index算palindromeList記錄起來
 * 2. 再Iteratnio一次有以下四種case:
 * 
 * -> case1: map裡面包含字串的reverse (如: "abcd", "dcba") 
 * 
 * -> case2: 不同長度時, 從後面開始去: 
 *    ex: "race","car"
 *    j = 1 -> "rac", "e" -> 第二部分"e"是palindrome -> 檢查"rac"是否有包含在map裡 -> 有(原words是否有包含"car") -> 加入i, map.get(first)
 *    j = 2 -> "ra", "ce" -> 第二部分"ce"不是palindrome -> 結束
 *    j = 3 -> "r", "ace" -> 第二部分"ace"不是palindrome -> 結束
 * 
 * -> case3: 不同長度時, 從前面開始去:
 *    ex: "lls","s"
 *    j = 1 -> "l", "ls" -> 第一部分"l"是palindrome -> 檢查"ls"是否有包含在map裡 -> 沒有(原words是否有包含"sl")
 *    j = 2 -> "ll", "s" -> 第一部分"ll"是palindrome -> 檢查"s"是否有包含在map裡 -> 有(原words是否有包含"s") -> 加入map.get(second), i
 * 
 * -> special case: 空字串代表和每個原本就是palindrome的字串都可以組成palindrome, 所以加上palindromeList的每一個index
 * 
 * Time complexity: O(N)
 * Space complexity: O(N)
 *
 */
class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> wrap = new LinkedList<>();
        HashMap<String, Integer> map = new HashMap<>();
        List<Integer> palindromeList = new LinkedList<>();
        for (int i = 0; i < words.length; i++) {
            map.put(reverse(words[i]), i);
            if (!words[i].isEmpty() && isPalindrome(words[i])) {
                palindromeList.add(i);
            }
        }

        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            
            // specail case: empty string (因為輸人都是unique, 所以空字串只會出現一次)
            if (s.isEmpty()) {
                for (int j : palindromeList) {
                    wrap.add(Arrays.asList(i, j));
                    wrap.add(Arrays.asList(j, i));
                }
                continue;
            }
            
            // case 1: 相同length, 直接找是否在map裡有對應的字
            if (map.containsKey(s) && i != map.get(s)) {
                wrap.add(Arrays.asList(i, map.get(s)));
            }
            
            // 不同length, j表示去掉的長度
            for (int j = 1; j < s.length(); j++) {
                               
                // case 2: 從後面開始去:
                first = s.substring(0, s.length() - j);
                second = s.substring(s.length() - j, s.length());
                if (isPalindrome(second) && map.containsKey(first) && map.get(first) != i) {
                    wrap.add(Arrays.asList(i, map.get(first)));
                }
                
                // case 3: 從前面開始去 : 
                
                String first = s.substring(0, j);
                String second = s.substring(j, s.length());
                if (isPalindrome(first) && map.containsKey(second) && map.get(second) != i) {
                    wrap.add(Arrays.asList(map.get(second), i));
                }

            }
            
        }
        return wrap;
    }
    
    private String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
    
    private boolean isPalindrome(String s) {
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