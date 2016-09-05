package leetcode._1sttime.no029;

/**
 * Pay a lot attention to OVERFLOW & UNDERFLOW !!!!!!!
 *
 * Created by zkf on 12/30/15.
 */
public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0)
            return Integer.MAX_VALUE;
        if (dividend == 0)
            return 0;

        boolean neg = false;
        if (dividend < 0) {
            neg = !neg;
        }
        if (divisor < 0){
            neg = ! neg;
        }

        long tmp = Math.abs((long) divisor), times = 1;
        long lDivd = Math.abs((long) dividend);
        long lDivs = tmp;
        while(lDivd >= tmp){
            tmp <<= 1;
            times <<= 1;
        }

        long result = 0;
        long remainder = lDivd;
        while (remainder >= lDivs){
            tmp >>= 1;
            times >>= 1;
            if(remainder >= tmp){
                remainder -= tmp;
                result += times;
            }
        }

        result = neg ? -result : result;
        if(result < Integer.MIN_VALUE || result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        else
            return (int)result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().divide(-2147483648, 1));
    }
}
