/**
 * 參考: https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/discuss/78566/Java-intuitive-22ms-solution-with-stack
 * 
 * 從左到右scan
 * 1.遇到數字, push到stack : 開始explore一個全新的sub tree, root為此數字
 * 
 * 2.遇到#, 分為兩種情況:
 * 2.1: stack的top為數字, 代表left tree explore完畢, 要展開right tree的explore, 故放一個#在stack, 代表左邊tree已經explore完
 * 2.2: stack的top為#, 代表right tree explore完畢, 退回上一層(連續兩次pop())
 * 
 * 當退回上一層後發現,
 * stack的top為數字, 代表要執行上一層的left tree explore完畢, 要展開right tree explore, 故放一個#在stack
 * stack的top為#, 代表此層已經explore完畢, 再退回上一層(連續兩次pop())
 * 
 * 最後stack只會剩下一個#
 * 
 * Time complexity: O(N)
 * Space complexity: O(N) 
 *
 */
class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] tokens = preorder.split(",");
        Stack<String> stack = new Stack<>();
        for (String c : tokens) {
            while (c.equals("#") && !stack.isEmpty() && stack.peek().equals("#")) {
                stack.pop();
                if (stack.isEmpty())
                    return false;
                stack.pop();
            }
            stack.push(c);
        }
        
        return stack.size() == 1 && stack.peek().equals("#");
    }
}