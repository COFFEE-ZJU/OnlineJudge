package leetcode._2ndtime.no349;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Whiteboard coding!
 */
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return new int[0];
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 == 0 || len2 == 0) return new int[0];

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i1 = 0, i2 = 0;
        List<Integer> res = new ArrayList<>();
        int prev = 0;
        while (i1 < len1 && i2 < len2) {
            if (nums1[i1] == nums2[i2]) {
                i1++;
                i2++;
                if (!res.isEmpty() && prev == nums1[i1-1]) continue;

                prev = nums1[i1-1];
                res.add(prev);
            } else if (nums1[i1] < nums2[i2]) {
                i1++;
            } else {
                i2++;
            }
        }

        int[] ret = new int[res.size()];
        for (int i = 0; i < ret.length; i++) ret[i] = res.get(i);
        return ret;
    }
}