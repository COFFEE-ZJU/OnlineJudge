package leetcode._1sttime.no201;

public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int shift = 0;
        while (m != n){
            m = m >> 1;
            n = n >> 1;
            shift ++;
        }
        return m << shift;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.rangeBitwiseAnd(5,7));
        System.out.println(sol.rangeBitwiseAnd(0,1));
        System.out.println(sol.rangeBitwiseAnd(4,8));
        System.out.println(sol.rangeBitwiseAnd(14,15));

    }
}
