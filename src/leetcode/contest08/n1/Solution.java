package leetcode.contest08.n1;

public class Solution {
    public String addStrings(String num1, String num2) {
        int l1, l2;
        if (num1 == null || (l1 = num1.length()) == 0) return num2;
        if (num2 == null || (l2 = num2.length()) == 0) return num1;

        char[] res = new char[Math.max(l1, l2) + 1];
        int l = res.length;
        int carry = 0;
        int i = 1;
        for (; i <= Math.max(l1, l2); i++) {
            char c1 = i > l1 ? '0' : num1.charAt(l1 - i),
                    c2 = i > l2 ? '0' : num2.charAt(l2 - i);
            carry += (c1 - '0' + c2 - '0');
            res[l - i] = (char)(carry % 10 + '0');
            carry /= 10;
        }

        if (carry != 0) {
            res[l - i] = (char)(carry + '0');
        }
        return res[0] == 0 ? new String(res).substring(1) : new String(res);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().addStrings("0", "0"));
    }
}