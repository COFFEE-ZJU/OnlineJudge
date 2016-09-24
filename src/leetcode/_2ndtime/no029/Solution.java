package leetcode._2ndtime.no029;

/**
 * Whiteboard coding!
 */
public class Solution {
    private long rem;
    public int divide(int dividend, int divisor) {
        if (divisor == 0) return dividend >= 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        boolean neg = false;
        long dvs;

        if (dividend < 0) {
            neg = !neg;
            rem = 0l - dividend;
        } else {
            rem = dividend;
        }
        if (divisor < 0) {
            neg = !neg;
            dvs = 0l - divisor;
        } else {
            dvs = divisor;
        }
        int res = div(dvs);
        return neg ? -res : res;
    }

    private int div(long dvs) {
        if (dvs > rem) return 0;
        int res = div(dvs + dvs);
        res += res;
        if (rem >= dvs) {
            rem -= dvs;
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().divide(1, -1));
    }
}