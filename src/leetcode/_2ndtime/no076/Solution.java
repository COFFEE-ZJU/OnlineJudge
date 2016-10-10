package leetcode._2ndtime.no076;

import java.util.Arrays;

/**
 * Whiteboard coding!
 */

public class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null) return "";
        int sl = s.length(), tl = t.length();
        if (sl == 0 || tl == 0) return "";

        int[] req = new int[128];
        for (int i = 0; i < tl; i++) {
            req[t.charAt(i)]++;
        }
        int ccnt = 0;
        for (int r : req) {
            if (r != 0) ccnt++;
        }
        int[] cnt = Arrays.copyOf(req, 128);

        int len = Integer.MAX_VALUE, st = 0, end = 0;
        for (int i = 0, j = 0; j < sl; ) {
            while (j < sl) {
                char c = s.charAt(j++);
                if (req[c] != 0 && --cnt[c] == 0 && --ccnt == 0) {
                    break;
                }
            }
            while (i < j) {
                char c = s.charAt(i);
                if (req[c] != 0 && ++cnt[c] == 1 && ++ccnt == 1) {
                    if (len > j - i) {
                        len = j - i;
                        st = i;
                        end = j;
                    }
                    i++;
                    break;
                }
                i++;
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(st, end);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minWindow("bba", "ab"));
    }
}