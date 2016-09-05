package leetcode._2ndtime.no179;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Whiteboard coding!
 */
public class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "";
        List<Integer> ns = new ArrayList<>(nums.length);
        for (int n : nums) ns.add(n);

        Collections.sort(ns, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (""+o2+o1).compareTo(""+o1+o2);
            }
        });

        if (ns.get(0) == 0) return "0";
        StringBuilder sb = new StringBuilder();
        for (Integer n : ns) sb.append(n);
        return sb.toString();
    }
}