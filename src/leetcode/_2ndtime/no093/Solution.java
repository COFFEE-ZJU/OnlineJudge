package leetcode._2ndtime.no093;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Whiteboard coding!
 */

public class Solution {
    private String s;
    private int len;
    private StringBuilder sb = new StringBuilder();
    private List<String> res;
    public List<String> restoreIpAddresses(String s) {
        this.s = s;
        if (s == null || (len = s.length()) == 0) return Collections.emptyList();

        sb.setLength(0);
        res = new ArrayList<>();
        restore(0, 0);
        return res;
    }

    private void restore(int st, int cnt) {
        int oriLen = sb.length();
        if (st == len && cnt == 4) {
            res.add(sb.toString());
        }
        if (st == len || cnt == 4) return;

        if (oriLen != 0) sb.append('.');
        for (int i = st, cur = 0; i < len; i++) {
            char c = s.charAt(i);
            cur = cur * 10 + (c - '0');
            if (cur > 255) break;
            sb.append(c);
            restore(i+1, cnt+1);
            if (cur == 0) break;
        }
        sb.setLength(oriLen);
    }
}