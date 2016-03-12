package cn.edu.zju.coffee.leetcode.no009;

public class Solution {
    public boolean isPalindrome(int x) {
        if (x == 0) return true;
        if (x < 0) return false;
        long hMask = 1, lMask = 1;
        while (x / hMask != 0)
            hMask *= 10;
        hMask /= 10;

        while (hMask > lMask) {
            if (x / hMask % 10 != x / lMask % 10)
                return false;

            hMask /= 10;
            lMask *= 10;
        }

        return true;
    }

    public static void main(String[] args) {
		Solution sol = new Solution();
        System.out.println(sol.isPalindrome(0));
        System.out.println(sol.isPalindrome(-1));
        System.out.println(sol.isPalindrome(1));
        System.out.println(sol.isPalindrome(123));
        System.out.println(sol.isPalindrome(-121));
        System.out.println(sol.isPalindrome(Integer.MIN_VALUE));
    }
}
