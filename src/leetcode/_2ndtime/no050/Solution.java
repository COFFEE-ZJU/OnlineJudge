package leetcode._2ndtime.no050;

/**
 * Whiteboard coding!
 */

public class Solution {
    public double myPow(double x, int n) {
        boolean isNeg = false;
        if (n < 0) {
            n = -n;
            isNeg = true;
        }
        double res = 1.0, cur = x;

        while (n != 0) {
            if (n % 2 != 0) {
                res *= cur;
            }
            cur *= cur;
            n /= 2;
        }

        return isNeg ? 1.0 / res : res;
    }
}