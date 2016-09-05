package leetcode._1sttime.no306;

import java.math.BigInteger;

public class Solution {
    public boolean isAdditiveNumber(String num) {
        int len;
        if (num == null || (len=num.length()) <= 2) return false;

        int bound = len / 3 * 2;
        BigInteger n1 = BigInteger.ZERO;
        boolean iFixed = false;
        for (int i = 0; i < bound - 1; i++) {
            int cur = num.charAt(i) - '0';
            if (iFixed) return false;
            if (i == 0 && cur == 0) iFixed = true;
            n1 = n1.multiply(BigInteger.TEN).add(BigInteger.valueOf(cur));
            BigInteger n2 = BigInteger.ZERO;

            boolean jFixed = false;
            for (int j = i+1; j < bound; j++) {
                int cur2 = num.charAt(j) - '0';
                if (jFixed) break;
                if (j == i+1 && cur2 == 0) jFixed = true;
                n2 = n2.multiply(BigInteger.TEN).add(BigInteger.valueOf(cur2));
                if (isAdditiveNumber(num, j+1, n1, n2)) return true;
            }
        }

        return false;
    }

    private boolean isAdditiveNumber(String num, int i, BigInteger n1, BigInteger n2) {
        for (; i < num.length();) {
            BigInteger next = n1.add(n2);
            String nextStr = next.toString();
            if (! num.startsWith(nextStr, i)) return false;

            i += nextStr.length();
            n1 = n2;
            n2 = next;
        }
        return true;
    }

    public static void main(String[] args) {
		Solution sol = new Solution();
        System.out.println(sol.isAdditiveNumber("123"));
        System.out.println(sol.isAdditiveNumber("223"));
        System.out.println(sol.isAdditiveNumber("101"));
        System.out.println(sol.isAdditiveNumber("011"));
        System.out.println(sol.isAdditiveNumber("001"));
        System.out.println(sol.isAdditiveNumber("000"));
    }
}
