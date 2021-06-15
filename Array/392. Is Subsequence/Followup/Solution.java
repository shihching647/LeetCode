/**
 * Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 10^9, 
 * and you want to check one by one to see if t has its subsequence.
 * In this scenario, how would you change your code?
 * (t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100))
 * 
 * 想法：
 * 先把t的每個字母出現的index存在charListArray, 如t = "bahbgdca"
 * charListArray['a'] = {1,7}, 
 * charListArray['b'] = {0,3}... (已排好序)
 * 
 * 當s進來query時候, iterate s的每個字母, 若字母存在於t, 
 * 使用binary seach找到charListArray[c]對應於該index的t的index
 * (注：binary search的特性 -> 若找不到對應的元素, 假設此元素該insert的位置為j, 會回傳 -j - 1)
 * 可用此特性來決定s的該字母c對應的charListArray[c]的index
 *  
 * 
 * Time complexity: O(KMlogN + N), M = s.length(), N = t.length() (the other mrthod is : O(KN))
 * Space complexity: O(N)
 */

class Solution {
    public boolean isSubsequence(String s, String t) {
        
        // preprocess t
        List<Integer>[] charListArray = new List[256];
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (charListArray[c] == null)
                charListArray[c] = new ArrayList<>();
            charListArray[c].add(i);
        }

        // s query
        int pre = 0; // 前一個字母對應t的index位置
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (charListArray[c] == null) return false; // 該元素不在t內, 直接return false
            int j = Collections.binarySearch(charListArray[c], pre);
            if (j < 0) j = -j - 1;
            if (j == charListArray[c].size()) return false; // j == list的長度代表, 此元素在t內但是沒有小於前一個字母的位置, 直接return false
            pre = charListArray[c].get(j) + 1; // 代表此元素在t內, 且index為charListArray[c].get(j), 故下一個要從 + 1開始找
        }
        return true;
    }
}