package cn.edu.zju.coffee.leetcode.no299;

import java.util.Arrays;

public class Solution {
    private static final char endChar = '9'+1;
    public String getHint(String secret, String guess) {
        if (secret == null || guess == null) return "0A0B";
        if (secret == guess || secret.equals(guess)) return secret.length() + "A0B";

        int len = secret.length();
        char[] sc = secret.toCharArray(), gc = guess.toCharArray();
        int A = 0, B = 0;
        for (int i = 0; i < len; i++) {
            if (sc[i] == gc[i]){
                sc[i] = gc[i] = endChar;
                A++;
            }
        }
        Arrays.sort(sc);
        Arrays.sort(gc);
        for (int i = 0, j = 0; i < len && j < len; ) {
            char s = sc[i], g = gc[j];
            if (s == endChar || g == endChar) break;
            if (s < g)
                i++;
            else if (g < s)
                j++;
            else {
                i++;j++;
                B++;
            }
        }

        return A+"A"+B+"B";
    }

    public static void main(String[] args) {
		Solution sol = new Solution();
        System.out.println(sol.getHint("1123", "0111"));
        System.out.println(sol.getHint("1807", "7810"));
    }
}
