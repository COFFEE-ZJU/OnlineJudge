package cn.edu.zju.coffee.leetcode.no007;

public class Solution {
    public int reverse(int x) {
        boolean neg = false;
        long n = x, rev = 0;
        if (x < 0) {
            neg = true;
            n = -(long)x;
        }
        while (n != 0) {
            rev = rev * 10 + n % 10;
            n /= 10;
            if (rev > Integer.MAX_VALUE) return 0;
        }

        return (int) (neg ? -rev : rev);
    }

    public static void main(String[] args) {
		Solution sol = new Solution();
        System.out.println(sol.reverse(123));
        System.out.println(sol.reverse(-123));
        System.out.println(sol.reverse(-1230));
        System.out.println(sol.reverse(0));
        System.out.println(sol.reverse(Integer.MIN_VALUE));
        System.out.println(Integer.MIN_VALUE);
    }
}
