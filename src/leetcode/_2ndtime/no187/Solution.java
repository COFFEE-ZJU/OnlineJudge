package leetcode._2ndtime.no187;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Whiteboard coding!
 */
public class Solution {
    private static final int mask = (1 << 20) - 1;
    public List<String> findRepeatedDnaSequences(String s) {
        if (s == null || s.length() <= 10) return Collections.emptyList();
        int seq = 0;
        for (int i = 0; i < 10; i++) {
            seq = (seq << 2) + charToBit(s.charAt(i));
        }
        seq = seq & mask;
        Set<Integer> set = new HashSet<>();
        Set<String> res = new HashSet<>();
        set.add(seq);
        for (int i = 10; i < s.length(); i++) {
            seq = ((seq << 2) + charToBit(s.charAt(i))) & mask;
            if (!set.add(seq)) {
                res.add(s.substring(i-9, i+1));
            }
        }

        return new ArrayList<>(res);
    }

    private int charToBit(char c) {
        return "ACGT".indexOf(c);
    }
}