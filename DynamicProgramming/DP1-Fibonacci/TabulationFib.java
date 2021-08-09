/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

/**
 * Tabulation(Bottom up) dynamic programming(usually iteration) to calculate Fibonacci number
 */

public class TabulationFib {

    private static final int MAX = 100;
    private int[] table;

    public TabulationFib(int max) {
        table = new int[max + 1];
        table[0] = 0;
        table[1] = 1;
        for (int i = 2; i <= max; i++)
            table[i] = table[i - 1] + table[i - 2];
    }

    public int fib(int n) {
        return table[n];
    }

    public static void main(String[] args) {
        TabulationFib tabulationFib = new TabulationFib(MAX);
        // test case
        System.out.println("n\tfib(n)");
        for (int i = 0; i <= 40; i++) {
            System.out.println(i + "\t" + tabulationFib.fib(i));
        }
    }
}
