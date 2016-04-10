package leetcode.no338;

import java.util.Arrays;

public class Solution {
    public int[] countBits(int num) {
        if (num < 0) return new int[0];
        int[] res = new int[num+1];
        int cur = 1;
        long sqr = 1;
        while (true) {
            for (int i = 0; i < sqr; i++) {
                if (cur > num) return res;

                res[cur++] = res[i] + 1;
            }
            sqr *= 2;
        }
    }

    public static void main(String[] args) {
		Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.countBits(5)));
    }
}
