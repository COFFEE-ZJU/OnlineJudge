package leetcode._1sttime.no050;

/**
 * Created by zkf on 1/7/16.
 */
public class Solution {
    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (x == 1.0 || x == 0.0)
            return x;
        if (x == -1.0)
            return (n%2 == 0) ? 1 : -1;

        boolean neg = false;
        if (n < 0){
            neg = true;
            n = -n;
        }
        double res = 1;
        for (double cur = x; n != 0; cur *= cur, n >>= 1){
            if (n % 2 == 1)
                res *= cur;
        }

        return neg ? 1.0/res : res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.myPow(2.0, 0));
        System.out.println(sol.myPow(2.0, 1));
        System.out.println(sol.myPow(2.0, 3));
        System.out.println(sol.myPow(2.0, 10));
        System.out.println(sol.myPow(34.00515, -3));
    }
}
