package leetcode._2ndtime.no394;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Whiteboard coding!
 *
 */
public class Solution {
    public String decodeString(String s) {
        int len;
        if (s == null || (len=s.length()) == 0) return s;

        Deque<Integer> timeSt = new ArrayDeque<>();
        Deque<StringBuilder> sbSt = new ArrayDeque<>();

        StringBuilder sb = new StringBuilder();
        StringBuilder curSb = sb;

        int idx = 0;
        while (idx < len) {
            char c = s.charAt(idx++);
            if (c >= '0' && c <= '9') {
                int num = c-'0';

                while (idx < len) {
                    c = s.charAt(idx);
                    if (c >= '0' && c <= '9') num = num * 10 + (c - '0');
                    else break;
                    idx++;
                }

                curSb = new StringBuilder();
                sbSt.push(curSb);
                timeSt.push(num);
            } else if (c == '[') {
                continue;
            } else if (c == ']') {
                int time = timeSt.pop();
                StringBuilder prev = sbSt.pop();
                curSb = sbSt.isEmpty() ? sb : sbSt.peek();
                for (int i = 0; i < time; i++) {
                    curSb.append(prev);
                }
            } else {
                curSb.append(c);
            }
        }

        return sb.toString();
    }
}