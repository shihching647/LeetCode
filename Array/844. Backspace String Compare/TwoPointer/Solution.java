/**
 * 由最後往前看, 先找到s, t最後一個會活著的字母
 * 1.比較兩字母是否一樣
 * 2.檢查s,t是否其中一個已經結束了
 *
 * Time complexity: O(m + n) (m = s.length(), n = t.length())
 * Space complexity: O(1)
 */
class Solution {
    
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1, j = t.length() - 1;
        int skipS = 0, skipT = 0;
        
        while (i >= 0 || j >= 0) {
            // find s previous alive character
            while (i >= 0) {
                if (s.charAt(i) == '#') // 遇到'#', skipS++
                    skipS++;
                else if (skipS > 0) // 遇到非'#', 且skipS大於0, skipS--(表示跳過該字母)
                    skipS--;
                else break; // skipS == 0, 表示該字母要留下來
                i--;
            }
            
            // find t previous alive character
            while (j >= 0) {
                if (t.charAt(j) == '#')
                    skipT++;
                else if (skipT > 0)
                    skipT--;
                else break;
                j--;
            }

            // compare alive character
            if (i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j)) return false;
            
            // If expecting to compare char vs nothing         
            if ((i >= 0) != (j >= 0)) return false;
            
            // move to previous character
            i--;
            j--;
        }
        return true;
    }
}