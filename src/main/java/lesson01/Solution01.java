package lesson01;

public class Solution01 {
    public static void main(String[] args) {
        int n = 4421;
        Solution01 sol = new Solution01();
        System.out.println(sol.subtractProductAndSum(n));
    }

    /**
     * Given an integer number n, return the difference between the product of its digits and the sum of its digits.
     * @param n
     * @return
     */
    public int subtractProductAndSum(int n) {
        int sum = 0;
        int product = 1;
        while (n > 0) {
            int digit = n % 10;
            sum += digit;
            product *= digit;
            n /= 10;
        }
        return product - sum;
    }
}
