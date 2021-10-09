/**
 *  小數binary表示: 0.101 = 0/1 + 1/2 + 0/4 + 1/8, 給定一個0~1的實數, 印出binary representation
 *  1. 一直將num * 2 (往左移一個bit), 結果 >= 1代表此bit為1, else 代表為0.
 *  2. 與1/2比, 1/4比, 1/8比...>=填入1, 小於填入0
 *
 */
/**
 * 
 * Time complexity: O(32)
 * Space complexity: O(1)
 *
 */
class Solution {
    public static String printBinary(double num) {
        if (num >= 1 || num < 0)
            return "ERROR";

        StringBuilder binary = new StringBuilder("0.");
        while (num > 0) {
            if (binary.length() > 32)
                return "ERROR";

            double r = num * 2;
            if (r >= 1) {
                binary.append("1");
                num = r - 1;
            } else {
                binary.append("0");
                num = r;
            }
        }
        return binary.toString();
    }

    public static String printBinary2(double num) {
        if (num >= 1 || num < 0)
            return "ERROR";

        StringBuilder binary = new StringBuilder("0.");
        double base = 0.5;
        while (num > 0) {
            if (binary.length() > 32)
                return "ERROR";
            if (num >= base) {
                binary.append("1");
                num -= base;
            } else {
                binary.append("0");
            }
            base /= 2;
        }
        return binary.toString();
    }

    public static void main(String[] args) {
        System.out.println(printBinary2(0.0 / 2 + 0.0 / 4 + 0.0 / 8 + 0.0 / 16 + 1.0 / 32)); // 0.00001
        System.out.println(printBinary2(1.0 / 2 + 1.0 / 4 + 1.0 / 8 + 0.0 / 16 + 1.0 / 32)); // 0.11101
        System.out.println(printBinary2(1.0 / 2 + 1.0 / 4 + 1.0 / 8 + 1.0 / 16 + 1.0 / 32)); // 0.11111
        System.out.println(printBinary2(0.1)); // ERROR
        System.out.println(printBinary2(0.2)); // ERROR
        System.out.println(printBinary2(0.3)); // ERROR
        System.out.println(printBinary2(0.4)); // ERROR
    }
}