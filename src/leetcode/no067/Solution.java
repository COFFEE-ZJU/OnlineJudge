package leetcode.no067;

public class Solution {
    public String addBinary(String a, String b) {
        int lenA, lenB;
        if (a == null || (lenA=a.length()) == 0) return b;
        if (b == null || (lenB=b.length()) == 0) return a;
        if (lenA < lenB) return addBinary(b,a);
        char[] res = a.toCharArray();
        int carry = 0;
        int i = lenA-1;
        for (int j = lenB-1; i >=0 && j >=0 ; i--, j--) {
            int s = res[i] - '0' + b.charAt(j) - '0' + carry;
            carry = s / 2;
            res[i] = (char)(s % 2 + '0');
        }
        for (; i >= 0; i--) {
            if (carry == 0) break;
            int s = res[i] - '0' + carry;
            carry = s / 2;
            res[i] = (char)(s % 2 + '0');
        }

        if (carry == 1) return "1" + new String(res);
        else return new String(res);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
    }
}
