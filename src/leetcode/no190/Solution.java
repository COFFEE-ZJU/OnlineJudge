package leetcode.no190;

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int m1 = 1 << 31, m2 = 1;
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & m1) != 0)
                res |= m2;
            m1 >>>= 1;
            m2 <<= 1;
        }
        return res;
    }

    public static void main(String[] args) {
		Solution sol = new Solution();
        System.out.println(sol.reverseBits(43261596));
        System.out.println(sol.reverseBits(-1));
    }
}
