package leetcode._1sttime.no263and264;

public class Solution {
    public boolean isUgly(int num) {
        if (num <= 0) return false;
        if (num == 1) return true;

        if (num % 2 == 0) return isUgly(num / 2);
        if (num % 3 == 0) return isUgly(num / 3);
        if (num % 5 == 0) return isUgly(num / 5);

        return false;
    }

    public int nthUglyNumber(int n) {
        long[] list = new long[n];
        list[0] = 1;
        for (int i = 1; i < n; i++) {
            long min = Integer.MAX_VALUE;
            for (int j = i-1; j >=0 ; j--) {
                long cur = list[j] * 2l;
                if (cur <= list[i-1]) break;
                if (cur < min) min = cur;
            }
            for (int j = i-1; j >=0 ; j--) {
                long cur = list[j] * 3l;
                if (cur <= list[i-1]) break;
                if (cur < min) min = cur;
            }
            for (int j = i-1; j >=0 ; j--) {
                long cur = list[j] * 5l;
                if (cur <= list[i-1]) break;
                if (cur < min) min = cur;
            }
            list[i] = min;
        }

        return (int)list[n-1];
    }

    public static void main(String[] args) {
		Solution sol = new Solution();
        System.out.println(sol.nthUglyNumber(1));
        System.out.println(sol.nthUglyNumber(2));
        System.out.println(sol.nthUglyNumber(10));
        System.out.println(sol.nthUglyNumber(1487));
    }
}
