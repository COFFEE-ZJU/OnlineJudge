package leetcode.no008;

public class Solution {
    private final long posMax = Integer.MAX_VALUE;
    public int myAtoi(String str) {
        if (str == null)
            return 0;
        str = str.trim();
        if (str.length() == 0) return 0;

        boolean neg = false;
        int i = 0;
        long val = 0;
        if (str.charAt(0) == '-') {
            neg = true;
            i++;
        }
        else if (str.charAt(0) == '+')
            i++;

        for (; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '.') break;
            if (c == ',' || c == ' ' || c == '\t') break;
            if (c < '0' || c > '9') break;
            val = val * 10 + (c - '0');
            if (neg && val > posMax+1)
                return Integer.MIN_VALUE;
            if (!neg && val > posMax)
                return Integer.MAX_VALUE;
        }

        return (int)(neg ? -val : val);
    }

    public static void main(String[] args) {
		Solution sol = new Solution();
        System.out.println(sol.myAtoi("123"));
        System.out.println(sol.myAtoi("0"));
        System.out.println(sol.myAtoi("0123"));
        System.out.println(sol.myAtoi("-0123"));
        System.out.println(sol.myAtoi("-0"));
        System.out.println(sol.myAtoi("-12"));
        System.out.println(sol.myAtoi("-12,345,666"));
        System.out.println(sol.myAtoi("-12,345,666.2"));
        System.out.println(sol.myAtoi("-1299999,345,666.2"));
    }
}
