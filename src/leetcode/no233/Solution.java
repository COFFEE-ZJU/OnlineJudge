package leetcode.no233;

public class Solution {
    public int countDigitOne(int n) {
        if (n <= 0) return 0;
        long cnt = 0, norm = 0;
        for (long di = 1; n / di != 0; ){
            long cd = n / di % 10;
            cnt += cd * norm;
            if (cd > 1) cnt += di;
            else if (cd == 1) cnt += (n % di) + 1;

            norm = 10 * norm + di;
            di *= 10;
        }

        return (int)cnt;
    }

    public static void main(String[] args) {
		Solution sol = new Solution();
        System.out.println(sol.countDigitOne(1));
        System.out.println(sol.countDigitOne(2));
        System.out.println(sol.countDigitOne(10));
        System.out.println(sol.countDigitOne(13));
        System.out.println(sol.countDigitOne(20));
        System.out.println(sol.countDigitOne(99));
        System.out.println(sol.countDigitOne(100));
        System.out.println(sol.countDigitOne(101));
        System.out.println(Integer.MAX_VALUE);
    }
}
