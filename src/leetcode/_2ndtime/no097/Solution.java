package leetcode._2ndtime.no097;

import java.util.HashSet;
import java.util.Set;

/**
 * Whiteboard coding!
 */
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null) return false;

        int l1 = s1.length();
        int l2 = s2.length();
        int l3 = s3.length();
        if (l1 + l2 != l3) return false;

        Set<Integer> cur = new HashSet<>();
        Set<Integer> next = new HashSet<>();
        cur.add(0);
        for (int i = 0; i < l3; i++) {
            if (cur.isEmpty()) return false;

            char c3 = s3.charAt(i);
            for (int i1 : cur) {
                int i2 = i - i1;
                if (i1 < l1 && s1.charAt(i1) == c3) next.add(i1+1);
                if (i2 < l2 && s2.charAt(i2) == c3) next.add(i1);
            }

            Set<Integer> t = cur;
            cur = next;
            next = t;
            next.clear();
        }
        return !cur.isEmpty();
    }
}