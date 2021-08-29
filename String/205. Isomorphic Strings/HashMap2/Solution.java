/**
 * 與Array2的想法一樣, 只是用HashMap實現
 * Time complexity: O(n)
 * Space complexity: O(n)
 *
 */
class Solution {
    
    public boolean isIsomorphic(String s, String t) {
        
        if (s.length() != t.length())
            return false;
        
        HashMap<Character, Integer> stMap = new HashMap<>();
        HashMap<Character, Integer> tsMap = new HashMap<>();

        // 這邊i要用Integer不能用int, 因為如果用int, 下面在put的時候, 會做Boxing(int -> Integer), 
        // 此時兩個map放進去的不會是同一個Integer物件, 因為下面是使用 != (比較reference是否不同), 故會出錯
        // (更正確來說,如果值不介於-128~127的話, 會是不同的物件 出處:https://dotblogs.com.tw/duke/2020/01/16/160734)
        for (Integer i = 0; i < s.length(); i++) { 
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            // map.put()回傳此key對應的到old value
            if (stMap.put(c1, i) != tsMap.put(c2, i))
                return false;
        }
        return true;
    }
}