package lesson01;

public class Solution02 {
    public static void main(String[] args) {
        String a = "11";
        String b = "1";

        Solution02 sol = new Solution02();
        System.out.println(sol.addBinary(a, b));
    }

    /**
     * 67. Add Binary
     * @param a
     * @param b
     * @return String
     */
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;

        int carry = 0;

        while (i >= 0 || j >= 0) {
            int sum = carry;

            if (i >= 0) {
                sum += a.charAt(i) - '0';
            }

            if (j >= 0) {
                sum += b.charAt(j) - '0';
            }

            result.append(sum % 2);
            carry = sum / 2;

            i--;
            j--;
        }

        if (carry != 0) {
            result.append(carry);
        }

        return result.reverse().toString();
    }
}
