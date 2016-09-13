package leetcode._2ndtime.no385;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Whiteboard coding!
 *
 */
public class Solution {
    public NestedInteger deserialize(String s) {
        int len;
        if (s == null || (len=s.length()) == 0) return null;

        Deque<NestedInteger> st = new ArrayDeque<>();
        NestedInteger curNi = new NestedInteger();
        st.push(curNi);
        int idx = 0;
        while (idx < len) {
            char c = s.charAt(idx++);
            if ((c >= '0' && c <= '9') || c == '-'){
                boolean neg = c == '-';
                if (neg) c = s.charAt(idx++);
                int num = c - '0';

                while (idx < len) {
                    c = s.charAt(idx);
                    if (c >= '0' && c <= '9') num = num * 10 + (c - '0');
                    else break;
                    idx++;
                }

                if (neg) num = -num;
                curNi.add(new NestedInteger(num));
            } else if (c == '[') {
                curNi = new NestedInteger();
                st.push(curNi);
            } else if (c == ']') {
                NestedInteger prev = st.pop();
                curNi = st.peek();
                curNi.add(prev);
            }
        }

        return curNi.getList().get(0);
    }
}