package leetcode._2ndtime.no043;

/**
 * Whiteboard coding!
 */

public class Solution {
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) return "";
        int len1 = num1.length(), len2 = num2.length(), len = len1 + len2;
        if (len1 == 0 || len2 == 0) return "";

        char[] res = new char[len];
        for (int i1 = 0; i1 < len1; i1++) {
            int pos = len2 + i1;
            int carry = 0;
            int cur = num1.charAt(i1) - '0';
            for (int i2 = len2-1; i2 >= 0; i2--, pos--) {
                int mul = cur * (num2.charAt(i2) - '0') + carry + res[pos];
                carry = mul / 10;
                res[pos] = (char)(mul % 10);
            }
            while (carry != 0) {
                carry += res[pos];
                res[pos--] = (char)(carry % 10);
                carry /= 10;
            }
        }

        int sti = -1;
        for (int i = 0; i < len; i++) {
            res[i] += '0';
            if (sti == -1 && res[i] != '0') sti = i;
        }
        return sti == -1 ? "0" : new String(res).substring(sti);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().multiply("123", "123"));
    }
}