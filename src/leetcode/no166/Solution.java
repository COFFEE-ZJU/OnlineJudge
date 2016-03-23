package leetcode.no166;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0)
            throw new IllegalArgumentException();
        if (numerator == 0)
            return "0";

        boolean neg = false;
        long num = numerator, den = denominator;
        if (num < 0){
            neg = !neg;
            num = -num;
        }
        if (den < 0){
            neg = !neg;
            den = -den;
        }

        long div = num / den;
        long rem = num % den;
        if (rem == 0)
            return (neg ? "-" : "") + div;

        Map<Long, Integer> posMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        while (rem != 0){
            Integer pos = posMap.get(rem);
            if (pos != null) {
                sb.insert(pos.intValue(), '(');
                sb.append(')');
                break;
            }
            posMap.put(rem, sb.length());
            rem *= 10;
            sb.append(rem / den);
            rem = rem % den;
        }

        return (neg ? "-" : "") + div + "." + sb.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.fractionToDecimal(1,2));
        System.out.println(sol.fractionToDecimal(2,2));
        System.out.println(sol.fractionToDecimal(2,1));
        System.out.println(sol.fractionToDecimal(23,13));
    }
}
