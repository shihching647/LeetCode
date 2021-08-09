/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

/**
 * Memoization(Top Down) dynamic programming(usually recursion) to calculate Fibonacci number
 */
public class MemoizationFib {

    private static final int MAX = 100;

    public static int fib(int n, int[] memo) {
        // 因為memo[n] == 0, 所以要加這個條件, 否則當n == 0時會呼叫到fib(-1, memo)
        if (n == 0) return 0;
        if (memo[n] > 0)
            return memo[n];
        memo[n] = fib(n - 1, memo) + fib(n - 2, memo);
        return memo[n];
    }

    public static void main(String[] args) {
        int[] memo = new int[MAX];
        // base case
        memo[0] = 0;
        memo[1] = 1;

        // test case
        System.out.println("n\tfib(n)");
        for (int i = 1; i <= 40; i++) {
            System.out.println(i + "\t" + fib(i, memo));
        }
    }
}
