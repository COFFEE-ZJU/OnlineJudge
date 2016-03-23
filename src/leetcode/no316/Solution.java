package leetcode.no316;

import java.util.Arrays;

public class Solution {
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() <= 1) return s;

        int[] cnts = new int[26];
        char[] cs = s.toCharArray();
        for (char c : cs)
            cnts[c-'a']++;

        int idx = 0;
        StringBuilder sb = new StringBuilder();
        boolean[] used = new boolean[26];
        while (idx < cs.length) {
            int[] tmpCnts = Arrays.copyOf(cnts, 26);
            int minPos = -1;
            char curMin = 'z' + 1;
            for (int i = idx; i < cs.length; i++) {
                char c = cs[i];
                if (used[c-'a']) continue;

                if (c < curMin) {
                    curMin = c;
                    minPos = i;
                }
                if (tmpCnts[c-'a'] == 1)
                    break;
                tmpCnts[c-'a']--;
            }

            if (minPos == -1) break;

            sb.append(curMin);
            used[curMin-'a'] = true;
            for (int i = idx; i <= minPos; i++)
                cnts[cs[i]-'a']--;
            idx = minPos + 1;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
		Solution sol = new Solution();
        System.out.println(sol.removeDuplicateLetters("bcabc"));
        System.out.println(sol.removeDuplicateLetters("cbacdcbc"));
    }
}
