/**
 * Lagrange's four-square theorem
 * 任何自然數都可以拆成4個完全平方數的和 -> 代表答案1~4之中
 * 
 * Legendre's three-square theorem
 * 任何自然數只要不滿足 n = 4^a(8*b+7) (a, b為正整數), 都可拆成3個完全平方數的和
 * 
 * 參考: https://www.youtube.com/watch?v=1xfx6M_GqFk&ab_channel=TECHDOSE
 * Time Complexity: O(√n)
 * Space Complexity: O(1)
 */

class Solution {
    public int numSquares(int n) {
        // 本身就是完全平方數 -> 回傳1
        if (isPerfectSquare(n))
            return 1;
        
        // Legendre's three-square theorem
        while (n % 4 == 0) {
            n /= 4;
        }
        if (n % 8 == 7)
            return 4;
        
        // 檢查是否可拆成兩個完全平方數的和
        for (int i = 1; i * i <= n; i++) {
            if (isPerfectSquare(n - i * i))
                return 2;
        }

        // 其他都是3
        return 3;
    }
    
    private boolean isPerfectSquare(int x) {
        int sqrt = (int) Math.sqrt(x);
        return sqrt * sqrt == x;
    }
}