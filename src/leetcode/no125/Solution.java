package leetcode.no125;

import java.util.Arrays;

public class Solution {
    public boolean isPalindrome(String s) {
        char[] cs = process(s);
        if (cs == null)
            return true;

        int l = 0, r = cs.length-1;
        while (l < r){
            if (cs[l++] != cs[r--])
                return false;
        }
        return true;
    }

    private char[] process(String s){
        if (s == null || s.length() <= 1)
            return null;
        char[] cs = s.toCharArray();
        int i = 0;
        for (int j = 0; j < cs.length; j++){
            char c = cs[j];
            if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z'))
                cs[i++] = c;
            else if (c >= 'A' && c <= 'Z')
                cs[i++] = (char) (c - 'A' + 'a');

        }

        return Arrays.copyOf(cs, i);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(sol.isPalindrome("race a car"));
    }
}