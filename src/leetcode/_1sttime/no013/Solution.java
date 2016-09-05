package leetcode._1sttime.no013;

public class Solution {
    private static final int[] charToNum = new int[26];
    static {
        charToNum['i'-'a'] = 1;
        charToNum['x'-'a'] = 10;
        charToNum['c'-'a'] = 100;
        charToNum['m'-'a'] = 1000;
        charToNum['v'-'a'] = 5;
        charToNum['l'-'a'] = 50;
        charToNum['d'-'a'] = 500;
    }

    public int romanToInt(String s) {
        if (s == null || s.length() == 0) return 0;
        s = s.toLowerCase();
        int num = 0, prev = 10000;
        for (char c : s.toCharArray()) {
            int cur = charToNum[c-'a'];
            num += cur;
            if (cur > prev)
                num -= 2*prev;

            prev = cur;
        }

        return num;
    }

    public static void main(String[] args) {
		Solution sol = new Solution();
        System.out.println(sol.romanToInt("MCMLXXX"));
    }
}
